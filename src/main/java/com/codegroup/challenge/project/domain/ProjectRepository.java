package com.codegroup.challenge.project.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProjectRepository {

    Project save(Project project);

    List<Project> findAll();

    Optional<Project> findById(UUID id);

    void deleteById(UUID id);

}
