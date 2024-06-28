package com.synergech.UserAccountService.shared.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST , code = HttpStatus.BAD_REQUEST)
public class BadRequestException extends Exception{

    private String message;

    @Override
    public String getMessage() {
        return message;
    }
    public BadRequestException(String message) {
        this.message = message;
    }
}
