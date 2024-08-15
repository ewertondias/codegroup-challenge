package com.codegroup.challenge.project.application;

import com.codegroup.challenge.project.GetAllProjectUseCase;
import com.codegroup.challenge.project.adapter.in.api.assembler.ProjectAssembler;
import com.codegroup.challenge.project.adapter.in.api.dto.ProjectResponse;
import com.codegroup.challenge.project.domain.Project;
import com.codegroup.challenge.project.domain.ProjectRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GetAllProjectService implements GetAllProjectUseCase {

    private final ProjectRepository projectRepository;

    public GetAllProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Page<ProjectResponse> handle(Pageable pageable) {
        Page<Project> projects = projectRepository.findAll(pageable);

        return projects.map(ProjectAssembler::toProjectResponse);
    }

}
