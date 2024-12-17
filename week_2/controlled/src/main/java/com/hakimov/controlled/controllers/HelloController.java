package com.hakimov.controlled.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping()
public class HelloController {
    @GetMapping("/home")
    public String sayHello(@RequestParam(value="name", required=false) String name,
                           Model model) {
        model.addAttribute("name", name);
        return "/say_hello";
    }
}
