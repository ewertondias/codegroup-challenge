package com.codegroup.challenge.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProjectNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Project not found";

    public ProjectNotFoundException() {
        super(MESSAGE);
    }

}
