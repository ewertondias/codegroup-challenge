package com.codegroup.challenge.project.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProjectRepository {

    Project save(Project project);

    List<Project> findAll();

    Optional<Project> findById(UUID id);

    void deleteById(UUID id);

    Page<Project> findAll(Pageable pageable);

}
