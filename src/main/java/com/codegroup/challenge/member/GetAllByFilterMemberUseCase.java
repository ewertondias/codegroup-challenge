package com.codegroup.challenge.member;

import com.codegroup.challenge.member.adapter.in.api.dto.MemberResponse;
import com.codegroup.challenge.member.domain.enums.MemberPositionEnum;

import java.util.List;

public interface GetAllByFilterMemberUseCase {

    List<MemberResponse> handle(MemberPositionEnum positionEnum);

}
