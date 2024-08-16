package com.codegroup.challenge.member;

import com.codegroup.challenge.member.domain.Member;

import java.util.UUID;

public interface GetByIdMemberUseCase {

    Member handle(UUID id);

}
