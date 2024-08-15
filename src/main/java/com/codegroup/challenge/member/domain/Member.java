package com.codegroup.challenge.member.domain;

import com.codegroup.challenge.member.domain.enums.MemberPositionEnum;
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
