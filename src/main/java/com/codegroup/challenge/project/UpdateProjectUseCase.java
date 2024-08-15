package com.codegroup.challenge.project;

import com.codegroup.challenge.project.adapter.in.api.dto.ProjectRequest;
import com.codegroup.challenge.project.adapter.in.api.dto.ProjectResponse;

import java.util.UUID;

public interface UpdateProjectUseCase {

    ProjectResponse handle(UUID id, ProjectRequest projectRequest);

}
