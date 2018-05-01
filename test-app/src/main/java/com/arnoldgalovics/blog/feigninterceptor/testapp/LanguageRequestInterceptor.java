package com.arnoldgalovics.blog.feigninterceptor.testapp;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
public class LanguageRequestInterceptor implements RequestInterceptor {
    private static final String ACCEPT_LANGUAGE_HEADER = "Accept-Language";

    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return;
        }
        HttpServletRequest request = requestAttributes.getRequest();
        if (request == null) {
            return;
        }
        String language = request.getHeader(ACCEPT_LANGUAGE_HEADER);
        if (language == null) {
            return;
        }
        requestTemplate.header(ACCEPT_LANGUAGE_HEADER, language);
    }
}
