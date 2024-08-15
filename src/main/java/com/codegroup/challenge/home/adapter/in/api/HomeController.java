package com.codegroup.challenge.home.adapter.in.api;

import com.codegroup.challenge.project.GetAllProjectUseCase;
import com.codegroup.challenge.project.adapter.in.api.dto.ProjectResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private final GetAllProjectUseCase getAllProject;

    public HomeController(GetAllProjectUseCase getAllProject) {
        this.getAllProject = getAllProject;
    }

    @GetMapping
    public String home(Model model) {
        List<ProjectResponse> projects = getAllProject.handle();

        model.addAttribute("projects", projects);

        return "home/home";
    }

}
