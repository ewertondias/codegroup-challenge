package com.codegroup.challenge.project.application;

import com.codegroup.challenge.project.UpdateProjectUseCase;
import com.codegroup.challenge.project.adapter.in.api.assembler.ProjectAssembler;
import com.codegroup.challenge.project.adapter.in.api.dto.ProjectRequest;
import com.codegroup.challenge.project.adapter.in.api.dto.ProjectResponse;
import com.codegroup.challenge.project.domain.ProjectRepository;
import com.codegroup.challenge.project.exception.ProjectNotFoundException;
import com.codegroup.challenge.util.DateTimeUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateProjectService implements UpdateProjectUseCase {

    private final ProjectRepository repository;

    public UpdateProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProjectResponse handle(UUID id, ProjectRequest request) {
        var project = repository.findById(id)
            .orElseThrow(ProjectNotFoundException::new);

        var startDate = DateTimeUtils.toLocalDate(request.getStartDate());
        var estimatedEndDate = DateTimeUtils.toLocalDate(request.getEstimatedEndDate());
        var actualEndDate = DateTimeUtils.toLocalDate(request.getActualEndDate());

        project.update()
            .name(request.getName())
            .manager(request.getManager())
            .startDate(startDate)
            .estimatedEndDate(estimatedEndDate)
            .actualEndDate(actualEndDate)
            .budget(request.getBudget())
            .description(request.getDescription())
            .risk(request.getRisk())
            .status(request.getStatus())
            .apply();

        var updatedProject = repository.save(project);

        return ProjectAssembler.toProjectResponse(updatedProject);
    }

}
