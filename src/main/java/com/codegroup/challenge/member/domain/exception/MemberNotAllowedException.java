package com.codegroup.challenge.member.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class MemberNotAllowedException extends RuntimeException {

    private static final String MESSAGE = "Member with position invalid for add to project";

    public MemberNotAllowedException() {
        super(MESSAGE);
    }

}
