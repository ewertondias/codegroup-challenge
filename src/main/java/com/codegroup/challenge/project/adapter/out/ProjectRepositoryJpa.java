package com.codegroup.challenge.project.adapter.out;

import com.codegroup.challenge.project.domain.Project;
import com.codegroup.challenge.project.domain.ProjectRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProjectRepositoryJpa extends ProjectRepository, JpaRepository<Project, UUID> {
}
