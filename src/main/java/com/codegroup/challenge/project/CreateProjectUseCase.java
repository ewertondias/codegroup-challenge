package com.codegroup.challenge.project;

import com.codegroup.challenge.project.adapter.in.api.dto.ProjectRequest;
import com.codegroup.challenge.project.adapter.in.api.dto.ProjectResponse;

public interface CreateProjectUseCase {

    ProjectResponse handle(ProjectRequest request);

}
