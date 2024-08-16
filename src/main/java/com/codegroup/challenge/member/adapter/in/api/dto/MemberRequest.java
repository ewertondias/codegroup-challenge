package com.codegroup.challenge.member.adapter.in.api.dto;

import com.codegroup.challenge.member.domain.enums.MemberPositionEnum;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serial;
import java.io.Serializable;

public class MemberRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 4765109350309851854L;

    @Schema(description = "Member name", example = "Michael Scott")
    private String name;

    @Schema(description = "Member position")
    private MemberPositionEnum position;

    public MemberRequest(String name, MemberPositionEnum position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MemberPositionEnum getPosition() {
        return position;
    }

    public void setPosition(MemberPositionEnum position) {
        this.position = position;
    }

}