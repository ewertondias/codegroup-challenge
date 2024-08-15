package com.codegroup.challenge.project.adapter.in.api.assembler;

import com.codegroup.challenge.project.adapter.in.api.dto.ProjectResponse;
import com.codegroup.challenge.project.domain.Project;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProjectAssembler {

    private ProjectAssembler() {}

    public static ProjectResponse toProjectResponse(Project project) {
        return ProjectResponse.builder()
            .id(project.getId())
            .name(project.getName())
            .manager(project.getManager())
            .startDate(formatDate(project.getStartDate()))
            .estimatedEndDate(formatDate(project.getEstimatedEndDate()))
            .actualEndDate(formatDate(project.getActualEndDate()))
            .budget(project.getBudget())
            .description(project.getDescription())
            .risk(project.getRisk())
            .status(project.getStatus())
            .build();
    }

    private static String formatDate(LocalDate date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d/M/y");
        return date.format(dateTimeFormatter);
    }

}
