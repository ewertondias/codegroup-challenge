package com.codegroup.challenge.member.util;

import com.codegroup.challenge.member.adapter.in.api.dto.MemberRequest;
import com.codegroup.challenge.member.domain.Member;
import com.codegroup.challenge.member.domain.MemberBuilder;
import com.codegroup.challenge.member.domain.enums.MemberPositionEnum;

import java.util.UUID;

public class MemberTestFactory {

    public static MemberBuilder memberBuilder() {
        return Member.builder()
            .id(UUID.randomUUID())
            .name("Member")
            .position(MemberPositionEnum.FUNCIONARIO);
    }

    public static Member member() {
        return memberBuilder().build();
    }

    public static Member memberWithPosition(MemberPositionEnum position) {
        return memberBuilder()
            .position(position)
            .build();
    }

    public static MemberRequest memberRequest() {
        return new MemberRequest("Member test", MemberPositionEnum.FUNCIONARIO);
    }

}
