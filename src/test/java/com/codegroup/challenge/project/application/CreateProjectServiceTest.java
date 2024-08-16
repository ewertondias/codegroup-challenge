package com.codegroup.challenge.project.application;

import com.codegroup.challenge.project.domain.Project;
import com.codegroup.challenge.project.util.ProjectTestFactory;
import com.codegroup.challenge.util.CreateServicesIT;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@DisplayName("Testes for Project - Create Project Service")
@SpringBootTest
class CreateProjectServiceTest extends CreateServicesIT {

    @Test
    @DisplayName("Must create a project")
    void mustCreateProject() {
        var request = ProjectTestFactory.projectRequest();
        var project = ProjectTestFactory.project();

        when(projectRepository.save(any(Project.class))).thenReturn(project);

        var newProject = createProject.handle(request);

        assertNotNull(newProject);
        assertEquals(request.getName(), newProject.getName());
    }

}
