package com.codegroup.challenge.member.adapter.in.api.dto;

import com.codegroup.challenge.member.domain.enums.MemberPositionEnum;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

public class MemberResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -5600858417801324925L;

    private final UUID id;
    private final String name;
    private final MemberPositionEnum position;

    public MemberResponse(MemberResponseBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.position = builder.position;
    }

    public static MemberResponseBuilder builder() {
        return new MemberResponseBuilder();
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
