package com.codegroup.challenge.project.adapter.in.api;

import com.codegroup.challenge.member.GetByIdMemberUseCase;
import com.codegroup.challenge.project.AddMemberProjectUseCase;
import com.codegroup.challenge.project.CreateProjectUseCase;
import com.codegroup.challenge.project.DeleteProjectUseCase;
import com.codegroup.challenge.project.GetByIdProjectUseCase;
import com.codegroup.challenge.project.UpdateProjectUseCase;
import com.codegroup.challenge.project.adapter.in.api.dto.ProjectRequest;
import com.codegroup.challenge.project.adapter.in.api.dto.ProjectResponse;
import com.codegroup.challenge.project.domain.enums.RiskEnum;
import com.codegroup.challenge.project.domain.enums.StatusEnum;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private static final String PROJECT_VIEW = "project";
    private static final String PROJECT_CREATE_VIEW = "project/create";

    private final CreateProjectUseCase createProject;
    private final GetByIdProjectUseCase getByIdProject;
    private final UpdateProjectUseCase updateProject;
    private final DeleteProjectUseCase deleteProject;
    private final GetByIdMemberUseCase getByIdMember;
    private final AddMemberProjectUseCase addMemberProject;

    public ProjectController(CreateProjectUseCase createProject, GetByIdProjectUseCase getByIdProject,
                             UpdateProjectUseCase updateProject, DeleteProjectUseCase deleteProject,
                             GetByIdMemberUseCase getByIdMember, AddMemberProjectUseCase addMemberProject) {
        this.createProject = createProject;
        this.getByIdProject = getByIdProject;
        this.updateProject = updateProject;
        this.deleteProject = deleteProject;
        this.getByIdMember = getByIdMember;
        this.addMemberProject = addMemberProject;
    }

    @GetMapping("/create")
    public String createView(Model model) {
        model.addAttribute(PROJECT_VIEW, new ProjectRequest());

        this.loadModel(model);

        return PROJECT_CREATE_VIEW;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Valid ProjectRequest request, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();

            bindingResult.getFieldErrors().forEach(
                error -> errors.put(error.getField(), error.getDefaultMessage())
            );

            model.addAttribute(PROJECT_VIEW, request);
            model.addAttribute("errors", errors);

            this.loadModel(model);

            return PROJECT_CREATE_VIEW;
        }

        createProject.handle(request);

        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String updateView(@PathVariable UUID id, Model model) {
        this.loadModel(model);

        var project = getByIdProject.handle(id);

        model.addAttribute(PROJECT_VIEW, project);

        return PROJECT_CREATE_VIEW;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponse> update(@PathVariable UUID id, @ModelAttribute @Valid ProjectRequest request, Model model) {
        var projectUpdate = updateProject.handle(id, request);

        model.addAttribute(PROJECT_VIEW, projectUpdate);

        return ResponseEntity.ok(projectUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteProject.handle(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/member")
    public String memberView(@PathVariable UUID id, Model model) {
        var project = getByIdProject.handle(id);

        model.addAttribute(PROJECT_VIEW, project);

        return "project/member";
    }

    @PutMapping("/{id}/member/{idMember}")
    public ResponseEntity<ProjectResponse> addMember(@PathVariable UUID id, @PathVariable UUID idMember) {
        var member = getByIdMember.handle(idMember);

        var project = addMemberProject.handle(id, member);
        return ResponseEntity.ok().body(project);
    }

    @GetMapping("/{id}/detail")
    public String detailView(@PathVariable UUID id, Model model) {
        var project = getByIdProject.handle(id);

        model.addAttribute(PROJECT_VIEW, project);

        return "project/detail";
    }

    private void loadModel(Model model) {
        model.addAttribute("risks", RiskEnum.values());
        model.addAttribute("status", StatusEnum.values());
    }

}
