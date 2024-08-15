package com.codegroup.challenge.project;

import com.codegroup.challenge.project.adapter.in.api.dto.ProjectResponse;

import java.util.List;

public interface GetAllProjectUseCase {

    List<ProjectResponse> handle();

}
