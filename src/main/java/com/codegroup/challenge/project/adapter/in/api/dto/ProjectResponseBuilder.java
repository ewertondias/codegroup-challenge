package com.codegroup.challenge.project.adapter.in.api.dto;

import com.codegroup.challenge.project.domain.enums.RiskEnum;
import com.codegroup.challenge.project.domain.enums.StatusEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class ProjectResponseBuilder {

    protected UUID id;
    protected String name;
    protected String manager;
    protected LocalDate startDate;
    protected LocalDate estimatedEndDate;
    protected LocalDate actualEndDate;
    protected BigDecimal budget;
    protected String description;
    protected RiskEnum risk;
    protected StatusEnum status;

    public ProjectResponseBuilder id(UUID id) {
        this.id = id;
        return this;
    }

    public ProjectResponseBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ProjectResponseBuilder manager(String manager) {
        this.manager = manager;
        return this;
    }

    public ProjectResponseBuilder startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public ProjectResponseBuilder estimatedEndDate(LocalDate estimatedEndDate) {
        this.estimatedEndDate = estimatedEndDate;
        return this;
    }

    public ProjectResponseBuilder actualEndDate(LocalDate actualEndDate) {
        this.actualEndDate = actualEndDate;
        return this;
    }

    public ProjectResponseBuilder budget(BigDecimal budget) {
        this.budget = budget;
        return this;
    }

    public ProjectResponseBuilder description(String description) {
        this.description = description;
        return this;
    }

    public ProjectResponseBuilder risk(RiskEnum risk) {
        this.risk = risk;
        return this;
    }

    public ProjectResponseBuilder status(StatusEnum status) {
        this.status = status;
        return this;
    }

    public ProjectResponse build() {
        return new ProjectResponse(this);
    }

}
