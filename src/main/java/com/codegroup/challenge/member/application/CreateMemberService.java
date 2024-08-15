package com.codegroup.challenge.member.application;

import com.codegroup.challenge.member.CreateMemberUseCase;
import com.codegroup.challenge.member.adapter.in.api.assembler.MemberAssembler;
import com.codegroup.challenge.member.adapter.in.api.dto.MemberRequest;
import com.codegroup.challenge.member.adapter.in.api.dto.MemberResponse;
import com.codegroup.challenge.member.domain.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateMemberService implements CreateMemberUseCase {

    private final MemberRepository repository;

    public CreateMemberService(MemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MemberResponse> handle(List<MemberRequest> request) {
        var members = request.stream()
            .map(MemberAssembler::toMember)
            .toList();

        var membersCreated = repository.saveAll(members);

        return membersCreated.stream()
            .map(MemberAssembler::toMemberResponse)
            .toList();
    }

}
