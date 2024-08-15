package com.codegroup.challenge.member.adapter.in.api;

import com.codegroup.challenge.member.GetAllByFilterMemberUseCase;
import com.codegroup.challenge.member.adapter.in.api.dto.MemberResponse;
import com.codegroup.challenge.member.domain.enums.MemberPositionEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/members")
public class MemberController {

    private final GetAllByFilterMemberUseCase getAllByFilterMember;

    public MemberController(GetAllByFilterMemberUseCase getAllByFilterMember) {
        this.getAllByFilterMember = getAllByFilterMember;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<MemberResponse>> getEmployees() {
        var members = getAllByFilterMember.handle(MemberPositionEnum.FUNCIONARIO);

        return ResponseEntity.ok().body(members);
    }

}
