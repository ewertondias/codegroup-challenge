package com.codegroup.challenge.member.domain;

import com.codegroup.challenge.member.domain.enums.MemberPositionEnum;
import com.codegroup.challenge.member.domain.exception.MemberNotAllowedException;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @Enumerated(EnumType.ORDINAL)
    private MemberPositionEnum position;

    public Member() {}

    public Member(MemberBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.position = builder.position;
    }

    public static MemberBuilder builder() {
        return new MemberBuilder();
    }

    public void verifyPositionToAddProject() {
        if (!MemberPositionEnum.FUNCIONARIO.equals(this.getPosition())) {
            throw new MemberNotAllowedException();
        }
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public MemberPositionEnum getPosition() {
        return position;
    }

}
