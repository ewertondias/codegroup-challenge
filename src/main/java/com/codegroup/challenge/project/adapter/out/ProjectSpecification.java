package com.codegroup.challenge.project.adapter.out;

import com.codegroup.challenge.project.domain.Project;
import com.codegroup.challenge.project.domain.enums.RiskEnum;
import com.codegroup.challenge.project.domain.enums.StatusEnum;
import org.springframework.data.jpa.domain.Specification;

public class ProjectSpecification {

    private ProjectSpecification() {}

    public static Specification<Project> whereRiskEquals(RiskEnum risk) {
        return (root, query, builder) -> builder.equal(root.get("risk"), risk);
    }

    public static Specification<Project> whereStatusEquals(StatusEnum status) {
        return (root, query, builder) -> builder.equal(root.get("status"), status);
    }

    public static Specification<Project> whereSearchContains(String search) {
        return (root, query, builder) -> builder.or(
            builder.like(builder.lower(root.get("name")), '%' + search + '%'),
            builder.like(builder.lower(root.get("manager")), '%' + search + '%'),
            builder.like(builder.lower(root.get("description")), '%' + search + '%')
        );
    }

}