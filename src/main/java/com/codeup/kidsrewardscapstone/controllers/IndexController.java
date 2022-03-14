package com.codeup.kidsrewardscapstone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.annotation.SessionScope;

@Controller
@SessionScope
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
