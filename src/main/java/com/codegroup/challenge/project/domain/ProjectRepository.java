package com.codegroup.challenge.project.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface ProjectRepository {

    Project save(Project project);

    Optional<Project> findById(UUID id);

    void deleteById(UUID id);

    Page<Project> findAll(Specification<Project> specs, Pageable pageable);

}
