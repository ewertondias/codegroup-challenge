package com.codegroup.challenge.project.application;

import com.codegroup.challenge.project.domain.enums.StatusEnum;
import com.codegroup.challenge.project.exception.DeleteNotAllowedException;
import com.codegroup.challenge.project.exception.ProjectNotFoundException;
import com.codegroup.challenge.project.util.ProjectTestFactory;
import com.codegroup.challenge.util.CreateServicesIT;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@DisplayName("Testes for Project - Delete Project Service")
class DeleteProjectServiceTest extends CreateServicesIT {

    @Test
    @DisplayName("Must delete a project")
    void mustDeleteProject() {
        var request = ProjectTestFactory.projectRequest();
        var project = ProjectTestFactory.projectWithStatus(StatusEnum.EM_ANALISE);

        when(projectRepository.findById(any())).thenReturn(Optional.of(project));

        deleteProject.handle(request.getId());

        verify(projectRepository, times(1)).deleteById(project.getId());
    }

    @Test
    @DisplayName("Must throw an exception DeleteNotAllowedException if status project equal to Started")
    void mustThrowAnExceptionDeleteNotAllowedExceptionStatusStarted() {
        var request = ProjectTestFactory.projectRequest();
        var projectId = request.getId();
        var project = ProjectTestFactory.projectWithStatus(StatusEnum.INICIADO);

        when(projectRepository.findById(any())).thenReturn(Optional.of(project));

        assertThrows(DeleteNotAllowedException.class, () -> deleteProject.handle(projectId));
    }

    @Test
    @DisplayName("Must throw an exception DeleteNotAllowedException if status project equal to In Progress")
    void mustThrowAnExceptionDeleteNotAllowedExceptionStatusInProgress() {
        var request = ProjectTestFactory.projectRequest();
        var projectId = request.getId();
        var project = ProjectTestFactory.projectWithStatus(StatusEnum.EM_ANDAMENTO);

        when(projectRepository.findById(any())).thenReturn(Optional.of(project));

        assertThrows(DeleteNotAllowedException.class, () -> deleteProject.handle(projectId));
    }

    @Test
    @DisplayName("Must throw an exception DeleteNotAllowedException if status project equal to Closed")
    void mustThrowAnExceptionDeleteNotAllowedExceptionStatusClosed() {
        var request = ProjectTestFactory.projectRequest();
        var projectId = request.getId();
        var project = ProjectTestFactory.projectWithStatus(StatusEnum.ENCERRADO);

        when(projectRepository.findById(any())).thenReturn(Optional.of(project));

        assertThrows(DeleteNotAllowedException.class, () -> deleteProject.handle(projectId));
    }

    @Test
    @DisplayName("Must throw an exception ProjectNotFoundException")
    void mustThrowAnExceptionProjectNotFoundException() {
        var request = ProjectTestFactory.projectRequest();
        var projectId = request.getId();

        when(projectRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(ProjectNotFoundException.class, () -> deleteProject.handle(projectId));
    }

}
