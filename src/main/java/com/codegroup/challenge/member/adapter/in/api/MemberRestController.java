package com.codegroup.challenge.member.adapter.in.api;

import com.codegroup.challenge.member.CreateMemberUseCase;
import com.codegroup.challenge.member.adapter.in.api.dto.MemberRequest;
import com.codegroup.challenge.member.adapter.in.api.dto.MemberResponse;
import com.codegroup.challenge.member.adapter.in.api.openapi.MemberRestControllerOpenApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberRestController implements MemberRestControllerOpenApi {

    private final CreateMemberUseCase createMember;

    public MemberRestController(CreateMemberUseCase createMember) {
        this.createMember = createMember;
    }

    @PostMapping
    @Override
    public ResponseEntity<List<MemberResponse>> create(@RequestBody List<MemberRequest> request) {
        var membersCreated = createMember.handle(request);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(membersCreated);
    }

}
