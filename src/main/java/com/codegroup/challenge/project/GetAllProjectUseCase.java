package com.codegroup.challenge.project;

import com.codegroup.challenge.project.adapter.in.api.dto.ProjectResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetAllProjectUseCase {

    Page<ProjectResponse> handle(Pageable pageable);

}
