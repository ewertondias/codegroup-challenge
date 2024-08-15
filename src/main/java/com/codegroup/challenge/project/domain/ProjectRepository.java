package com.codegroup.challenge.project.domain;

import java.util.List;

public interface ProjectRepository {

    Project save(Project project);

    List<Project> findAll();

}
