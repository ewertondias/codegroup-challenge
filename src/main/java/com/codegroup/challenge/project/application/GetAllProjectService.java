package com.codegroup.challenge.project.application;

import com.codegroup.challenge.project.GetAllProjectUseCase;
import com.codegroup.challenge.project.adapter.in.api.assembler.ProjectAssembler;
import com.codegroup.challenge.project.adapter.in.api.dto.ProjectResponse;
import com.codegroup.challenge.project.domain.Project;
import com.codegroup.challenge.project.domain.ProjectRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class GetAllProjectService implements GetAllProjectUseCase {

    private final ProjectRepository repository;

    public GetAllProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<ProjectResponse> handle(Specification<Project> specs, Pageable pageable) {
        Page<Project> projects = repository.findAll(specs, pageable);

        return projects.map(ProjectAssembler::toProjectResponse);
    }

}
