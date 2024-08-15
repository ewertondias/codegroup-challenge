package com.codegroup.challenge.project.application;

import com.codegroup.challenge.project.GetAllProjectUseCase;
import com.codegroup.challenge.project.adapter.in.api.assembler.ProjectAssembler;
import com.codegroup.challenge.project.adapter.in.api.dto.ProjectResponse;
import com.codegroup.challenge.project.domain.Project;
import com.codegroup.challenge.project.domain.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllProjectService implements GetAllProjectUseCase {

    private final ProjectRepository projectRepository;

    public GetAllProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<ProjectResponse> handle() {
        List<Project> projects = projectRepository.findAll();

        return projects.stream()
            .map(ProjectAssembler::toProjectResponse)
            .toList();
    }

}
