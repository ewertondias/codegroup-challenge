package com.codegroup.challenge.project.application;

import com.codegroup.challenge.project.domain.Project;
import com.codegroup.challenge.project.exception.ProjectNotFoundException;
import com.codegroup.challenge.project.util.ProjectTestFactory;
import com.codegroup.challenge.util.CreateServicesIT;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@DisplayName("Testes for Project - Update Project Service")
class UpdateProjectServiceTest extends CreateServicesIT {

    @Test
    @DisplayName("Must update a project")
    void mustUpdateProject() {
        var request = ProjectTestFactory.projectRequest();
        var project = ProjectTestFactory.project();

        when(projectRepository.findById(any())).thenReturn(Optional.of(project));
        when(projectRepository.save(any(Project.class))).thenReturn(project);

        var updatedProject = updateProject.handle(request.getId(), request);

        assertNotNull(updatedProject);
        assertEquals(request.getName(), updatedProject.getName());
    }

    @Test
    @DisplayName("Must throw an exception ProjectNotFoundException")
    void mustThrowAnExceptionProjectNotFoundException() {
        var request = ProjectTestFactory.projectRequest();
        var projectId = request.getId();

        when(projectRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(ProjectNotFoundException.class, () -> updateProject.handle(projectId, request));
    }

}
