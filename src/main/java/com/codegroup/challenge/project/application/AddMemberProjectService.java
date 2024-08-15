package com.codegroup.challenge.project.application;

import com.codegroup.challenge.member.domain.Member;
import com.codegroup.challenge.project.AddMemberProjectUseCase;
import com.codegroup.challenge.project.adapter.in.api.assembler.ProjectAssembler;
import com.codegroup.challenge.project.adapter.in.api.dto.ProjectResponse;
import com.codegroup.challenge.project.domain.Project;
import com.codegroup.challenge.project.domain.ProjectRepository;
import com.codegroup.challenge.project.exception.ProjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AddMemberProjectService implements AddMemberProjectUseCase {

    private final ProjectRepository repository;

    public AddMemberProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProjectResponse handle(UUID id, Member member) {
        var project = repository.findById(id)
            .orElseThrow(ProjectNotFoundException::new);

        var memberAlreadyExists = project.getMembers().stream()
            .anyMatch(projectMember -> projectMember.getId().equals(member.getId()));

        if (!memberAlreadyExists) {
            project.addMember(member);
            repository.save(project);
        }

        return ProjectAssembler.toProjectResponse(project);
    }

}
