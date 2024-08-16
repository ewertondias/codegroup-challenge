package com.codegroup.challenge.project.application;

import com.codegroup.challenge.member.util.MemberTestFactory;
import com.codegroup.challenge.project.domain.Project;
import com.codegroup.challenge.project.exception.ProjectNotFoundException;
import com.codegroup.challenge.project.util.ProjectTestFactory;
import com.codegroup.challenge.util.CreateServicesIT;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@DisplayName("Testes for Project - Add Member in Project Service")
class AddMemberProjectServiceTest extends CreateServicesIT {

    @Test
    @DisplayName("Must add member to project")
    void mustAddMemberToProject() {
        var project = ProjectTestFactory.project();
        var member = MemberTestFactory.member();

        when(projectRepository.findById(any())).thenReturn(Optional.of(project));
        when(projectRepository.save(any(Project.class))).thenReturn(project);

        var projectResponse = addMemberProject.handle(project.getId(), member);

        assertNotNull(projectResponse);
        assertFalse(projectResponse.getMembers().isEmpty());
    }

    @Test
    @DisplayName("Must throw an exception ProjectNotFoundException")
    void mustThrowAnExceptionProjectNotFoundException() {
        var request = ProjectTestFactory.projectRequest();
        var projectId = request.getId();
        var member = MemberTestFactory.member();

        when(projectRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(ProjectNotFoundException.class, () -> addMemberProject.handle(projectId, member));
    }

}
