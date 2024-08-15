package com.codegroup.challenge.project.adapter.in.api.assembler;

import com.codegroup.challenge.project.adapter.in.api.dto.ProjectResponse;
import com.codegroup.challenge.project.domain.Project;

public class ProjectAssembler {

    private ProjectAssembler() {}

    public static ProjectResponse toProjectResponse(Project project) {
        return ProjectResponse.builder()
            .id(project.getId())
            .name(project.getName())
            .manager(project.getManager())
            .startDate(project.getStartDate())
            .estimatedEndDate(project.getEstimatedEndDate())
            .actualEndDate(project.getActualEndDate())
            .budget(project.getBudget())
            .description(project.getDescription())
            .risk(project.getRisk())
            .status(project.getStatus())
            .build();
    }

}
