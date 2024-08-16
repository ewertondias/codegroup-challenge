package com.codegroup.challenge.member.util;

import com.codegroup.challenge.member.domain.Member;
import com.codegroup.challenge.member.domain.enums.MemberPositionEnum;
import com.codegroup.challenge.project.adapter.in.api.dto.ProjectRequest;
import com.codegroup.challenge.project.adapter.in.api.dto.ProjectResponse;
import com.codegroup.challenge.project.domain.Project;
import com.codegroup.challenge.project.domain.ProjectBuilder;
import com.codegroup.challenge.project.domain.enums.RiskEnum;
import com.codegroup.challenge.project.domain.enums.StatusEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class MemberTestFactory {

    public static Member member() {
        return Member.builder()
            .id(UUID.randomUUID())
            .name("Member")
            .position(MemberPositionEnum.FUNCIONARIO)
            .build();
    }

}
