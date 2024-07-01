package com.synergech.UserAccountService.shared.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, code = HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException {

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public ConflictException(String message) {
        this.message = message;

    }
}

