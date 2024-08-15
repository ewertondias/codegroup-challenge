package com.codegroup.challenge.member.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MemberNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Member not found";

    public MemberNotFoundException() {
        super(MESSAGE);
    }

}
