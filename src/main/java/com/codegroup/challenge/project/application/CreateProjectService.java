package com.codegroup.challenge.project.application;

import com.codegroup.challenge.project.CreateProjectUseCase;
import com.codegroup.challenge.project.adapter.in.api.assembler.ProjectAssembler;
import com.codegroup.challenge.project.adapter.in.api.dto.ProjectRequest;
import com.codegroup.challenge.project.adapter.in.api.dto.ProjectResponse;
import com.codegroup.challenge.project.domain.Project;
import com.codegroup.challenge.project.domain.ProjectRepository;
import com.codegroup.challenge.util.DateTimeUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateProjectService implements CreateProjectUseCase {

    private final ProjectRepository repository;

    public CreateProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProjectResponse handle(ProjectRequest request) {
        var startDate = DateTimeUtils.toLocalDate(request.getStartDate());
        var estimatedEndDate = DateTimeUtils.toLocalDate(request.getEstimatedEndDate());
        var actualEndDate = DateTimeUtils.toLocalDate(request.getActualEndDate());

        var project = Project.builder()
            .id(UUID.randomUUID())
            .name(request.getName())
            .manager(request.getManager())
            .startDate(startDate)
            .estimatedEndDate(estimatedEndDate)
            .actualEndDate(actualEndDate)
            .budget(request.getBudget())
            .description(request.getDescription())
            .risk(request.getRisk())
            .status(request.getStatus())
            .build();

        var newProject = repository.save(project);

        return ProjectAssembler.toProjectResponse(newProject);
    }

}
