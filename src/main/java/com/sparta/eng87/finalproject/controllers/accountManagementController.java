package com.sparta.eng87.finalproject.controllers;

import com.sparta.eng87.finalproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.security.Principal;

@Controller
public class accountManagementController {

    private UserService userService;

    @Autowired
    public accountManagementController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/changePassword")
    public String changePassword(@RequestParam(name = "password1") String password,
                                 @RequestParam(name = "password2") String passwordConfirm,
                                 Model model, Principal principal) {
        String name = principal.getName();
        model.addAttribute("ReturnValue", userService.changePassword(name, password, passwordConfirm));
        return "/accountManagement";
    }
}
