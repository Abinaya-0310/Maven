package com.swapshelf.demo.controller;

import com.swapshelf.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        if (loginService.authenticate(email, password)) {
            return "redirect:/home.html";  // Redirect to home page
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "login";  // Stay on login page
        }
    }
}
