package com.arnoldgalovics.blog.feigninterceptor.translator.controller;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController("/message")
public class TranslationController {
    @RequestMapping
    public MessageResponse message(@RequestHeader(value = "Accept-Language") String language) {
        String message = "english";
        if (Locale.GERMANY.equals(Locale.forLanguageTag(language))) {
            message = "german";
        }
        return new MessageResponse(message);
    }
}

class MessageResponse {
    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
