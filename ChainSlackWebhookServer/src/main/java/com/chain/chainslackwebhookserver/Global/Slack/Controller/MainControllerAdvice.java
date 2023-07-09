package com.chain.chainslackwebhookserver.Global.Slack.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MainControllerAdvice {
    @ExceptionHandler(Exception.class)
    public String exception(Exception e) {
        return e.getMessage();
    }
    @ExceptionHandler(JsonProcessingException.class)
    public String jsonProcessingException(JsonProcessingException e) {
        return e.getMessage();
    }
}
