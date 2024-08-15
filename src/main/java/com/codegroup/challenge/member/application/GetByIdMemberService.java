package com.codegroup.challenge.member.application;

import com.codegroup.challenge.member.GetByIdMemberUseCase;
import com.codegroup.challenge.member.domain.Member;
import com.codegroup.challenge.member.domain.MemberRepository;
import com.codegroup.challenge.member.domain.exception.MemberNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetByIdMemberService implements GetByIdMemberUseCase {

    private final MemberRepository memberRepository;

    public GetByIdMemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member handle(UUID id) {
        return memberRepository.findById(id)
            .orElseThrow(MemberNotFoundException::new);
    }

}
