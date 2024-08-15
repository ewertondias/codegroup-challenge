package com.codegroup.challenge.project.adapter.in.api.dto;

import com.codegroup.challenge.project.domain.enums.RiskEnum;
import com.codegroup.challenge.project.domain.enums.StatusEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class ProjectResponse {

    private final UUID id;
    private final String name;
    private final String manager;
    private final LocalDate startDate;
    private final LocalDate estimatedEndDate;
    private final LocalDate actualEndDate;
    private final BigDecimal budget;
    private final String description;
    private final RiskEnum risk;
    private final StatusEnum status;

    public ProjectResponse(ProjectResponseBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.manager = builder.manager;
        this.startDate = builder.startDate;
        this.estimatedEndDate = builder.estimatedEndDate;
        this.actualEndDate = builder.actualEndDate;
        this.budget = builder.budget;
        this.description = builder.description;
        this.risk = builder.risk;
        this.status = builder.status;
    }

    public static ProjectResponseBuilder builder() {
        return new ProjectResponseBuilder();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getManager() {
        return manager;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEstimatedEndDate() {
        return estimatedEndDate;
    }

    public LocalDate getActualEndDate() {
        return actualEndDate;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public String getDescription() {
        return description;
    }

    public RiskEnum getRisk() {
        return risk;
    }

    public StatusEnum getStatus() {
        return status;
    }

}
