package com.demo.stocks.config;

import com.demo.stocks.exceptions.NoResultException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class ExceptionAdviceConfiguration {

    @ResponseBody
    @ExceptionHandler(NoResultException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String noResultExceptionHandler(NoResultException e) {
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ResponseStatusException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error responseStatusErrorExceptionHandler(ResponseStatusException e) {
        return new Error(e.getMessage());
    }

    static class Error {
        private final String message;

        public Error(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}