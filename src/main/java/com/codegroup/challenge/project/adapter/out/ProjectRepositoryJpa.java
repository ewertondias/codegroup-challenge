package com.codegroup.challenge.project.adapter.out;

import com.codegroup.challenge.project.domain.Project;
import com.codegroup.challenge.project.domain.ProjectRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectRepositoryJpa extends ProjectRepository, JpaRepository<Project, UUID> {
}
