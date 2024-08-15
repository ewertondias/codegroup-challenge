package com.codegroup.challenge.project;

import com.codegroup.challenge.project.adapter.in.api.dto.ProjectRequest;

import java.util.UUID;

public interface CreateProjectUseCase {

    UUID handle(ProjectRequest request);

}
