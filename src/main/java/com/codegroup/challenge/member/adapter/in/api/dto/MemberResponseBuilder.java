package com.codegroup.challenge.member.adapter.in.api.dto;

import java.util.UUID;

public class MemberResponseBuilder {

    protected UUID id;
    protected String name;

    public MemberResponseBuilder id(UUID id) {
        this.id = id;
        return this;
    }

    public MemberResponseBuilder name(String name) {
        this.name = name;
        return this;
    }

    public MemberResponse build() {
        return new MemberResponse(this);
    }

}
