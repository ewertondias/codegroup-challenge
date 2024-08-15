package com.codegroup.challenge.project;

import com.codegroup.challenge.member.domain.Member;
import com.codegroup.challenge.project.adapter.in.api.dto.ProjectResponse;
import com.codegroup.challenge.project.domain.Project;

import java.util.UUID;

public interface AddMemberProjectUseCase {

    ProjectResponse handle(UUID id, Member member);

}
