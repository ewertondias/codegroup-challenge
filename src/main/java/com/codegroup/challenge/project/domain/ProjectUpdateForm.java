package com.codegroup.challenge.project.domain;

import com.codegroup.challenge.project.domain.enums.RiskEnum;
import com.codegroup.challenge.project.domain.enums.StatusEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.function.Consumer;

public class ProjectUpdateForm {

    protected String name;
    protected String manager;
    protected LocalDate startDate;
    protected LocalDate estimatedEndDate;
    protected LocalDate actualEndDate;
    protected BigDecimal budget;
    protected String description;
    protected RiskEnum risk;
    protected StatusEnum status;

    private final Consumer<ProjectUpdateForm> apply;

    public ProjectUpdateForm(Consumer<ProjectUpdateForm> apply) {
        this.apply = apply;
    }

    public ProjectUpdateForm name(String name) {
        this.name = name;
        return this;
    }

    public ProjectUpdateForm manager(String manager) {
        this.manager = manager;
        return this;
    }

    public ProjectUpdateForm startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public ProjectUpdateForm estimatedEndDate(LocalDate estimatedEndDate) {
        this.estimatedEndDate = estimatedEndDate;
        return this;
    }

    public ProjectUpdateForm actualEndDate(LocalDate actualEndDate) {
        this.actualEndDate = actualEndDate;
        return this;
    }

    public ProjectUpdateForm budget(BigDecimal budget) {
        this.budget = budget;
        return this;
    }

    public ProjectUpdateForm description(String description) {
        this.description = description;
        return this;
    }

    public ProjectUpdateForm risk(RiskEnum risk) {
        this.risk = risk;
        return this;
    }

    public ProjectUpdateForm status(StatusEnum status) {
        this.status = status;
        return this;
    }

    public void apply() {
        this.apply.accept(this);
    }

}
