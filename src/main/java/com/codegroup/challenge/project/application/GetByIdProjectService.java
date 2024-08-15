package com.codegroup.challenge.project.application;

import com.codegroup.challenge.project.GetByIdProjectUseCase;
import com.codegroup.challenge.project.adapter.in.api.assembler.ProjectAssembler;
import com.codegroup.challenge.project.adapter.in.api.dto.ProjectResponse;
import com.codegroup.challenge.project.domain.ProjectRepository;
import com.codegroup.challenge.project.exception.ProjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetByIdProjectService implements GetByIdProjectUseCase {

    private final ProjectRepository repository;

    public GetByIdProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProjectResponse handle(UUID id) {
        var project = repository.findById(id)
            .orElseThrow(ProjectNotFoundException::new);

        return ProjectAssembler.toProjectResponse(project);
    }

}
