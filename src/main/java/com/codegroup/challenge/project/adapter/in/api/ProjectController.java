package com.codegroup.challenge.project.adapter.in.api;

import com.codegroup.challenge.project.CreateProjectUseCase;
import com.codegroup.challenge.project.DeleteProjectUseCase;
import com.codegroup.challenge.project.GetByIdProjectUseCase;
import com.codegroup.challenge.project.UpdateProjectUseCase;
import com.codegroup.challenge.project.adapter.in.api.dto.ProjectRequest;
import com.codegroup.challenge.project.adapter.in.api.dto.ProjectResponse;
import com.codegroup.challenge.project.domain.enums.RiskEnum;
import com.codegroup.challenge.project.domain.enums.StatusEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private final CreateProjectUseCase createProject;
    private final GetByIdProjectUseCase getByIdProject;
    private final UpdateProjectUseCase updateProject;
    private final DeleteProjectUseCase deleteProject;

    public ProjectController(CreateProjectUseCase createProject, GetByIdProjectUseCase getByIdProject,
                             UpdateProjectUseCase updateProject, DeleteProjectUseCase deleteProject) {
        this.createProject = createProject;
        this.getByIdProject = getByIdProject;
        this.updateProject = updateProject;
        this.deleteProject = deleteProject;
    }

    @GetMapping("/create")
    public String createView(Model model) {
        model.addAttribute("project", new ProjectRequest());
        model.addAttribute("risks", RiskEnum.values());
        model.addAttribute("status", StatusEnum.values());

        return "project/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute ProjectRequest request) {
        createProject.handle(request);

        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String updateView(@PathVariable UUID id, Model model) {
        model.addAttribute("risks", RiskEnum.values());
        model.addAttribute("status", StatusEnum.values());

        var project = getByIdProject.handle(id);
        model.addAttribute("project", project);

        return "project/create";
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponse> update(@PathVariable UUID id, @ModelAttribute ProjectRequest request, Model model) {
        var projectUpdate = updateProject.handle(id, request);

        model.addAttribute("project", projectUpdate);

        return ResponseEntity.ok(projectUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteProject.handle(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/member")
    public String member() {
        return "project/member";
    }

}
