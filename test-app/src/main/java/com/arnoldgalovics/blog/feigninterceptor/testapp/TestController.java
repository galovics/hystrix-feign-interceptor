package com.arnoldgalovics.blog.feigninterceptor.testapp;

import com.arnoldgalovics.blog.feigninterceptor.testapp.client.MessageResponse;
import com.arnoldgalovics.blog.feigninterceptor.testapp.client.TranslationClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/test")
public class TestController {
    @Autowired
    private TranslationClient client;

    @RequestMapping
    public TestResponse get() {
        MessageResponse messageResponse = client.message();
        String message = messageResponse.getMessage();
        return new TestResponse(message);
    }
}

class TestResponse {
    private String value;

    public TestResponse(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
