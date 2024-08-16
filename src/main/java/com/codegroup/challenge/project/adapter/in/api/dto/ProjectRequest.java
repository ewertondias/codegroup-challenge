package com.codegroup.challenge.project.adapter.in.api.dto;

import com.codegroup.challenge.project.domain.enums.RiskEnum;
import com.codegroup.challenge.project.domain.enums.StatusEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public class ProjectRequest {

    private UUID id;

    @NotBlank(message = "Name cannot be null or empty")
    private String name;

    @NotBlank(message = "Manager cannot be null or empty")
    private String manager;

    private String startDate;
    private String estimatedEndDate;
    private String actualEndDate;
    private BigDecimal budget;

    @NotBlank(message = "Description cannot be null or empty")
    private String description;

    @NotNull(message = "Risk cannot be null")
    private RiskEnum risk;

    @NotNull(message = "Status cannot be null")
    private StatusEnum status;

    public ProjectRequest() {}

    public ProjectRequest(ProjectRequestBuilder builder) {
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

    public static ProjectRequestBuilder builder() {
        return new ProjectRequestBuilder();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEstimatedEndDate() {
        return estimatedEndDate;
    }

    public void setEstimatedEndDate(String estimatedEndDate) {
        this.estimatedEndDate = estimatedEndDate;
    }

    public String getActualEndDate() {
        return actualEndDate;
    }

    public void setActualEndDate(String actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RiskEnum getRisk() {
        return risk;
    }

    public void setRisk(RiskEnum risk) {
        this.risk = risk;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

}
