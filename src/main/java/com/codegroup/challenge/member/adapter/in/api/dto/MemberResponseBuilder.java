package com.codegroup.challenge.member.adapter.in.api.dto;

import com.codegroup.challenge.member.domain.enums.MemberPositionEnum;

import java.util.UUID;

public class MemberResponseBuilder {

    protected UUID id;
    protected String name;
    protected MemberPositionEnum position;

    public MemberResponseBuilder id(UUID id) {
        this.id = id;
        return this;
    }

    public MemberResponseBuilder name(String name) {
        this.name = name;
        return this;
    }

    public MemberResponseBuilder position(MemberPositionEnum position) {
        this.position = position;
        return this;
    }

    public MemberResponse build() {
        return new MemberResponse(this);
    }

}
