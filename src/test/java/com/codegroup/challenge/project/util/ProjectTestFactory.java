package com.codegroup.challenge.project.util;

import com.codegroup.challenge.project.adapter.in.api.dto.ProjectRequest;
import com.codegroup.challenge.project.domain.Project;
import com.codegroup.challenge.project.domain.ProjectBuilder;
import com.codegroup.challenge.project.domain.enums.RiskEnum;
import com.codegroup.challenge.project.domain.enums.StatusEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class ProjectTestFactory {

    public static final UUID PROJECT_ID = UUID.randomUUID();
    public static final String PROJECT_TEST = "Project Test";
    public static final String TEST_MANAGER = "Test Manager";
    public static final String START_DATE = "15/08/2024";
    public static final String ESTIMATED_END_DATE = "16/08/2024";
    public static final String ACTUAL_END_DATE = "17/08/2024";
    public static final BigDecimal BUDGET = new BigDecimal("1000");
    public static final String TESTE_PROJECT = "Teste project";

    public static ProjectBuilder projectBuilder() {
        return Project.builder()
            .id(PROJECT_ID)
            .name(PROJECT_TEST)
            .manager(TEST_MANAGER)
            .startDate(LocalDate.parse("2024-08-15"))
            .estimatedEndDate(LocalDate.parse("2024-08-16"))
            .actualEndDate(LocalDate.parse("2024-08-17"))
            .budget(BUDGET)
            .description(TESTE_PROJECT)
            .risk(RiskEnum.ALTO)
            .status(StatusEnum.EM_ANDAMENTO);
    }

    public static Project projectWithStatus(StatusEnum statusEnum) {
        return projectBuilder()
            .status(statusEnum)
            .build();
    }

    public static Project project() {
        return projectBuilder().build();
    }

    public static ProjectRequest projectRequest() {
        return ProjectRequest.builder()
            .name(PROJECT_TEST)
            .manager(TEST_MANAGER)
            .startDate(START_DATE)
            .estimatedEndDate(ESTIMATED_END_DATE)
            .actualEndDate(ACTUAL_END_DATE)
            .budget(BUDGET)
            .description(TESTE_PROJECT)
            .risk(RiskEnum.ALTO)
            .status(StatusEnum.EM_ANDAMENTO)
            .build();
    }

}
