package com.synergech.UserAccountService.shared.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND , code = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    private String message;

    @Override
    public String getMessage() {
        return message;
    }
    public NotFoundException(String message) {
        this.message = message;
    }
}

