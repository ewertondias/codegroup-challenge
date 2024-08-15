package com.codegroup.challenge.member;

import com.codegroup.challenge.member.adapter.in.api.dto.MemberRequest;
import com.codegroup.challenge.member.adapter.in.api.dto.MemberResponse;

import java.util.List;

public interface CreateMemberUseCase {

    List<MemberResponse> handle(List<MemberRequest> request);

}
