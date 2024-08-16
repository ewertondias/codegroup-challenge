package com.codegroup.challenge.project.adapter.in.api.dto;

import com.codegroup.challenge.project.domain.enums.RiskEnum;
import com.codegroup.challenge.project.domain.enums.StatusEnum;

import java.math.BigDecimal;
import java.util.UUID;

public class ProjectRequestBuilder {

    protected UUID id;
    protected String name;
    protected String manager;
    protected String startDate;
    protected String estimatedEndDate;
    protected String actualEndDate;
    protected BigDecimal budget;
    protected String description;
    protected RiskEnum risk;
    protected StatusEnum status;

    public ProjectRequestBuilder id(UUID id) {
        this.id = id;
        return this;
    }

    public ProjectRequestBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ProjectRequestBuilder manager(String manager) {
        this.manager = manager;
        return this;
    }

    public ProjectRequestBuilder startDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public ProjectRequestBuilder estimatedEndDate(String estimatedEndDate) {
        this.estimatedEndDate = estimatedEndDate;
        return this;
    }

    public ProjectRequestBuilder actualEndDate(String actualEndDate) {
        this.actualEndDate = actualEndDate;
        return this;
    }

    public ProjectRequestBuilder budget(BigDecimal budget) {
        this.budget = budget;
        return this;
    }

    public ProjectRequestBuilder description(String description) {
        this.description = description;
        return this;
    }

    public ProjectRequestBuilder risk(RiskEnum risk) {
        this.risk = risk;
        return this;
    }

    public ProjectRequestBuilder status(StatusEnum status) {
        this.status = status;
        return this;
    }

    public ProjectRequest build() {
        return new ProjectRequest(this);
    }

}
