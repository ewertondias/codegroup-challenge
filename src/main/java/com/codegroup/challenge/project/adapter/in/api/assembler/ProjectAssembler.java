package com.codegroup.challenge.project.adapter.in.api.assembler;

import com.codegroup.challenge.member.adapter.in.api.assembler.MemberAssembler;
import com.codegroup.challenge.member.adapter.in.api.dto.MemberResponse;
import com.codegroup.challenge.member.domain.Member;
import com.codegroup.challenge.project.adapter.in.api.dto.ProjectResponse;
import com.codegroup.challenge.project.domain.Project;

import java.util.List;

import static com.codegroup.challenge.util.DateTimeUtils.toLocalDate;

public class ProjectAssembler {

    private ProjectAssembler() {}

    public static ProjectResponse toProjectResponse(Project project) {
        return ProjectResponse.builder()
            .id(project.getId())
            .name(project.getName())
            .manager(project.getManager())
            .startDate(toLocalDate(project.getStartDate()))
            .estimatedEndDate(toLocalDate(project.getEstimatedEndDate()))
            .actualEndDate(toLocalDate(project.getActualEndDate()))
            .budget(project.getBudget())
            .description(project.getDescription())
            .risk(project.getRisk())
            .status(project.getStatus())
            .members(buildMemberResponse(project.getMembers()))
            .build();
    }

    private static List<MemberResponse> buildMemberResponse(List<Member> members) {
        return members.stream()
            .map(MemberAssembler::toMemberResponse)
            .toList();
    }

}
