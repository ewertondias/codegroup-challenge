package com.codegroup.challenge.project.application;

import com.codegroup.challenge.project.domain.CreateProjectUseCase;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateProjectService implements CreateProjectUseCase {

    @Override
    public UUID handle() {
        return null;
    }

}
