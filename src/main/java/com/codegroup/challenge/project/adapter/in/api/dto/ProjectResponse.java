package com.codegroup.challenge.project.adapter.in.api.dto;

import com.codegroup.challenge.member.adapter.in.api.dto.MemberResponse;
import com.codegroup.challenge.project.domain.enums.RiskEnum;
import com.codegroup.challenge.project.domain.enums.StatusEnum;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProjectResponse {

    private final UUID id;
    private final String name;
    private final String manager;
    private final String startDate;
    private final String estimatedEndDate;
    private final String actualEndDate;
    private final BigDecimal budget;
    private final String description;
    private final RiskEnum risk;
    private final StatusEnum status;
    private final List<MemberResponse> members = new ArrayList<>();

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
        this.members.addAll(builder.members);
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

    public String getStartDate() {
        return startDate;
    }

    public String getEstimatedEndDate() {
        return estimatedEndDate;
    }

    public String getActualEndDate() {
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

    public List<MemberResponse> getMembers() {
        return members;
    }

}
