package com.codegroup.challenge.project;

import com.codegroup.challenge.project.adapter.in.api.dto.ProjectResponse;

import java.util.UUID;

public interface GetByIdProjectUseCase {

    ProjectResponse handle(UUID id);

}
