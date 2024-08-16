package com.codegroup.challenge.member.adapter.in.api.assembler;

import com.codegroup.challenge.member.adapter.in.api.dto.MemberRequest;
import com.codegroup.challenge.member.adapter.in.api.dto.MemberResponse;
import com.codegroup.challenge.member.domain.Member;

public class MemberAssembler {

    private MemberAssembler() {}

    public static MemberResponse toMemberResponse(Member member) {
        return MemberResponse.builder()
            .id(member.getId())
            .name(member.getName())
            .position(member.getPosition())
            .build();
    }

    public static Member toMember(MemberRequest request) {
        return Member.builder()
            .name(request.getName())
            .position(request.getPosition())
            .build();
    }

}
