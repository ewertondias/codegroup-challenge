package com.codegroup.challenge.project.adapter.in.api.dto;

import com.codegroup.challenge.project.domain.enums.RiskEnum;
import com.codegroup.challenge.project.domain.enums.StatusEnum;

import java.math.BigDecimal;
import java.util.UUID;

public class ProjectRequest {

    private UUID id;
    private String name;
    private String manager;
    private String startDate;
    private String estimatedEndDate;
    private String actualEndDate;
    private BigDecimal budget;
    private String description;
    private RiskEnum risk;
    private StatusEnum status;

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
