package com.codegroup.challenge.project.application;

import com.codegroup.challenge.project.exception.ProjectNotFoundException;
import com.codegroup.challenge.project.util.ProjectTestFactory;
import com.codegroup.challenge.util.CreateServicesIT;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@DisplayName("Testes for Project - Get All Project Service")
class GetAllProjectServiceTest extends CreateServicesIT {

    @Test
    @DisplayName("Must return a list of projects")
    void mustReturnAListOfProjects() {
        var project = ProjectTestFactory.project();

        when(projectRepository.findById(any())).thenReturn(Optional.of(project));

        var projectResponse = getByIdProject.handle(project.getId());

        assertNotNull(projectResponse);
    }

    @Test
    @DisplayName("Must throw an exception ProjectNotFoundException")
    void mustThrowAnExceptionProjectNotFoundException() {
        var request = ProjectTestFactory.projectRequest();
        var projectId = request.getId();

        when(projectRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(ProjectNotFoundException.class, () -> getByIdProject.handle(projectId));
    }

}
