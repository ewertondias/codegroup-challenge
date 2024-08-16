package com.codegroup.challenge.project.application;

import com.codegroup.challenge.project.CreateProjectUseCase;
import com.codegroup.challenge.project.adapter.in.api.assembler.ProjectAssembler;
import com.codegroup.challenge.project.adapter.in.api.dto.ProjectRequest;
import com.codegroup.challenge.project.adapter.in.api.dto.ProjectResponse;
import com.codegroup.challenge.project.domain.Project;
import com.codegroup.challenge.project.domain.ProjectRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class CreateProjectService implements CreateProjectUseCase {

    private final ProjectRepository repository;

    public CreateProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProjectResponse handle(ProjectRequest request) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var startDate = LocalDate.parse(request.getStartDate(), dateTimeFormatter);
        var estimatedEndDate = LocalDate.parse(request.getEstimatedEndDate(), dateTimeFormatter);
        var actualEndDate = LocalDate.parse(request.getActualEndDate(), dateTimeFormatter);

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
