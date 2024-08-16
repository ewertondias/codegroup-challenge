package com.codegroup.challenge.member.adapter.in.api.openapi;

import com.codegroup.challenge.member.adapter.in.api.dto.MemberRequest;
import com.codegroup.challenge.member.adapter.in.api.dto.MemberResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Member", description = "Api for management members")
public interface MemberRestControllerOpenApi {

    @Operation(
        summary = "Create new members",
        description = "Create new members based on the data provided",
        responses = {
            @ApiResponse(responseCode = "201", description = "Member created successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    ResponseEntity<List<MemberResponse>> create(@RequestBody List<MemberRequest> request);

}
