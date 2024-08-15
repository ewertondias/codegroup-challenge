package com.codegroup.challenge.member.domain;

import com.codegroup.challenge.member.domain.enums.MemberPositionEnum;

import java.util.UUID;

public class MemberBuilder {

    protected UUID id;
    protected String name;
    protected MemberPositionEnum position;

    public MemberBuilder id(UUID id) {
        this.id = id;
        return this;
    }

    public MemberBuilder name(String name) {
        this.name = name;
        return this;
    }

    public MemberBuilder position(MemberPositionEnum position) {
        this.position = position;
        return this;
    }

    public Member build() {
        return new Member(this);
    }

}
