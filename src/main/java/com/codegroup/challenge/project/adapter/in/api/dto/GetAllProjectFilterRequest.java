package com.codegroup.challenge.project.adapter.in.api.dto;

import com.codegroup.challenge.project.adapter.out.ProjectSpecification;
import com.codegroup.challenge.project.domain.Project;
import com.codegroup.challenge.project.domain.enums.RiskEnum;
import com.codegroup.challenge.project.domain.enums.StatusEnum;
import org.springframework.data.jpa.domain.Specification;

import static java.util.Objects.nonNull;

public class GetAllProjectFilterRequest {

    private RiskEnum risk;
    private StatusEnum status;
    private String search;

    public Specification<Project> buildSpecification() {
        Specification<Project> specs = Specification.where(null);

        specs = this.filterRisk(specs);
        specs = this.filterStatus(specs);
        specs = this.filterSearch(specs);

        return specs;
    }

    private Specification<Project> filterRisk(Specification<Project> specs) {
        if (nonNull(this.risk)) {
            specs = specs.and(ProjectSpecification.whereRiskEquals(this.risk));
        }

        return specs;
    }

    private Specification<Project> filterStatus(Specification<Project> specs) {
        if (nonNull(this.status)) {
            specs = specs.and(ProjectSpecification.whereStatusEquals(this.status));
        }

        return specs;
    }

    private Specification<Project> filterSearch(Specification<Project> specs) {
        if (nonNull(this.search)) {
            specs = specs.and(ProjectSpecification.whereSearchContains(this.search));
        }

        return specs;
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

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

}
