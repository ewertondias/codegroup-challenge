package com.codegroup.challenge.util;

import com.codegroup.challenge.project.AddMemberProjectUseCase;
import com.codegroup.challenge.project.CreateProjectUseCase;
import com.codegroup.challenge.project.DeleteProjectUseCase;
import com.codegroup.challenge.project.GetAllProjectUseCase;
import com.codegroup.challenge.project.GetByIdProjectUseCase;
import com.codegroup.challenge.project.UpdateProjectUseCase;
import com.codegroup.challenge.project.domain.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class CreateServicesIT {

    @MockBean
    public ProjectRepository projectRepository;

    @Autowired
    public CreateProjectUseCase createProject;

    @Autowired
    public UpdateProjectUseCase updateProject;

    @Autowired
    public DeleteProjectUseCase deleteProject;

    @Autowired
    public AddMemberProjectUseCase addMemberProject;

    @Autowired
    public GetAllProjectUseCase getAllProject;

    @Autowired
    public GetByIdProjectUseCase getByIdProject;

}
