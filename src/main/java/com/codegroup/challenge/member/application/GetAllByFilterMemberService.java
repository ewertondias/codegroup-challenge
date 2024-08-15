package com.codegroup.challenge.member.application;

import com.codegroup.challenge.member.GetAllByFilterMemberUseCase;
import com.codegroup.challenge.member.adapter.in.api.assembler.MemberAssembler;
import com.codegroup.challenge.member.adapter.in.api.dto.MemberResponse;
import com.codegroup.challenge.member.domain.MemberRepository;
import com.codegroup.challenge.member.domain.enums.MemberPositionEnum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllByFilterMemberService implements GetAllByFilterMemberUseCase {

    private final MemberRepository repository;

    public GetAllByFilterMemberService(MemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MemberResponse> handle(MemberPositionEnum positionEnum) {
        return repository.findAllByPosition(positionEnum).stream()
            .map(MemberAssembler::toMemberResponse)
            .toList();
    }

}
