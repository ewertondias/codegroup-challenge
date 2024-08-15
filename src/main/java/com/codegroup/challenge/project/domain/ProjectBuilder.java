package com.codegroup.challenge.project.domain;

import com.codegroup.challenge.project.domain.enums.RiskEnum;
import com.codegroup.challenge.project.domain.enums.StatusEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class ProjectBuilder {

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

    public ProjectBuilder id(UUID id) {
        this.id = id;
        return this;
    }

    public ProjectBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ProjectBuilder manager(String manager) {
        this.manager = manager;
        return this;
    }

    public ProjectBuilder startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public ProjectBuilder estimatedEndDate(LocalDate estimatedEndDate) {
        this.estimatedEndDate = estimatedEndDate;
        return this;
    }

    public ProjectBuilder actualEndDate(LocalDate actualEndDate) {
        this.actualEndDate = actualEndDate;
        return this;
    }

    public ProjectBuilder budget(BigDecimal budget) {
        this.budget = budget;
        return this;
    }

    public ProjectBuilder description(String description) {
        this.description = description;
        return this;
    }

    public ProjectBuilder risk(RiskEnum risk) {
        this.risk = risk;
        return this;
    }

    public ProjectBuilder status(StatusEnum status) {
        this.status = status;
        return this;
    }

    public Project build() {
        return new Project(this);
    }

}
