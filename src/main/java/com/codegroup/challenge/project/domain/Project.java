package com.codegroup.challenge.project.domain;

import com.codegroup.challenge.member.domain.Member;
import com.codegroup.challenge.project.domain.enums.RiskEnum;
import com.codegroup.challenge.project.domain.enums.StatusEnum;
import com.codegroup.challenge.project.exception.DeleteNotAllowedException;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Project implements Serializable {

    @Serial
    private static final long serialVersionUID = 8822478847305267685L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String manager;
    private LocalDate startDate;
    private LocalDate estimatedEndDate;
    private LocalDate actualEndDate;
    private BigDecimal budget;
    private String description;
    private RiskEnum risk;
    private StatusEnum status;

    @ManyToMany
    @JoinTable(
        name = "project_member",
        joinColumns = @JoinColumn(name = "project_id"),
        inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private final List<Member> members = new ArrayList<>();

    public Project() {}

    protected Project(ProjectBuilder builder) {
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

    public static ProjectBuilder builder() {
        return new ProjectBuilder();
    }

    public ProjectUpdateForm update() {
        return new ProjectUpdateForm(form -> {
            this.name = form.name;
            this.manager = form.manager;
            this.startDate = form.startDate;
            this.estimatedEndDate = form.estimatedEndDate;
            this.actualEndDate = form.actualEndDate;
            this.budget = form.budget;
            this.description = form.description;
            this.risk = form.risk;
            this.status = form.status;
        });
    }

    public void verifyStatusForDelete() {
        if (StatusEnum.INICIADO.equals(this.getStatus())
            || StatusEnum.EM_ANDAMENTO.equals(this.getStatus())
            || StatusEnum.ENCERRADO.equals(this.getStatus())) {
            throw new DeleteNotAllowedException();
        }
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

    public List<Member> getMembers() {
        return members;
    }

    public void addMember(Member member) {
        this.members.add(member);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id) && Objects.equals(name, project.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Project{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", manager='" + manager + '\'' +
            ", startDate=" + startDate +
            ", estimatedEndDate=" + estimatedEndDate +
            ", actualEndDate=" + actualEndDate +
            ", budget=" + budget +
            ", description='" + description + '\'' +
            ", risk=" + risk +
            ", status=" + status +
            ", members=" + members +
            '}';
    }

}
