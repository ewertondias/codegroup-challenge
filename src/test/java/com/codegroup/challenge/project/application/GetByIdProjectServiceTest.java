package com.codegroup.challenge.project.application;

import com.codegroup.challenge.project.adapter.in.api.dto.GetAllProjectFilterRequest;
import com.codegroup.challenge.project.domain.Project;
import com.codegroup.challenge.project.util.ProjectTestFactory;
import com.codegroup.challenge.util.CreateServicesIT;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@DisplayName("Testes for Project - Get All Project Service")
class GetByIdProjectServiceTest extends CreateServicesIT {

    @Test
    @DisplayName("Must return one project by id")
    void mustReturnOneProjectById() {
        var project = ProjectTestFactory.project();

        Page<Project> response = new PageImpl<>(List.of(project));

        var specification = new GetAllProjectFilterRequest().buildSpecification();
        var pageable = Pageable.unpaged();

        when(projectRepository.findAll(any(), any())).thenReturn(response);

        var pages = getAllProject.handle(specification, pageable);

        assertNotNull(pages.getContent());
    }

}
