package com.codegroup.challenge.home.adapter.in.api;

import com.codegroup.challenge.project.GetAllProjectUseCase;
import com.codegroup.challenge.project.adapter.in.api.dto.ProjectResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private final GetAllProjectUseCase getAllProject;

    public HomeController(GetAllProjectUseCase getAllProject) {
        this.getAllProject = getAllProject;
    }

    @GetMapping
    public String home(Pageable pageable, Model model) {
        var p = pageable.getPageNumber() > 0 ? pageable.getPageNumber() -1 : 0;
        Page<ProjectResponse> projects = getAllProject.handle(PageRequest.of(p, 3));

        model.addAttribute("projects", projects);
        model.addAttribute("hasPrevious", projects.hasPrevious());
        model.addAttribute("hasNext", projects.hasNext());
        model.addAttribute("pageNumber", projects.getPageable().getPageNumber() + 1);

        return "home/home";
    }

}
