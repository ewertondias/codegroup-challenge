package com.codegroup.challenge.project.application;

import com.codegroup.challenge.project.DeleteProjectUseCase;
import com.codegroup.challenge.project.domain.ProjectRepository;
import com.codegroup.challenge.project.exception.ProjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteProjectService implements DeleteProjectUseCase {

    private final ProjectRepository repository;

    public DeleteProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(UUID id) {
        var project = repository.findById(id)
            .orElseThrow(ProjectNotFoundException::new);

        project.verifyStatusForDelete();

        repository.deleteById(project.getId());
    }

}
