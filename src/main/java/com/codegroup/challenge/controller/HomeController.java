package com.codegroup.challenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home() {
        return "home/home";
    }

    @GetMapping("create")
    public String create() {
        return "project/create";
    }

    @GetMapping("member")
    public String member() {
        return "project/member";
    }

}
