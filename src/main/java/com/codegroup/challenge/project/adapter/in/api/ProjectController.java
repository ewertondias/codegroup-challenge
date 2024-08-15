package com.codegroup.challenge.project.adapter.in.api;

import com.codegroup.challenge.project.CreateProjectUseCase;
import com.codegroup.challenge.project.adapter.in.api.dto.ProjectRequest;
import com.codegroup.challenge.project.domain.enums.RiskEnum;
import com.codegroup.challenge.project.domain.enums.StatusEnum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private final CreateProjectUseCase createProject;

    public ProjectController(CreateProjectUseCase createProject) {
        this.createProject = createProject;
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

    @GetMapping("/member")
    public String member() {
        return "project/member";
    }

}
