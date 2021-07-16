package com.sparta.eng87.finalproject.controllers;

import com.sparta.eng87.finalproject.entities.DisciplineEntity;
import com.sparta.eng87.finalproject.services.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DisciplineController {

    private DisciplineService disciplineService;

    @Autowired
    public DisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @GetMapping("/addDiscipline")
    public String getAddDisciplinePage() {
        return "addDiscipline";
    }

    @PostMapping("/addDiscipline")
    public String addDiscipline(@RequestParam(name = "discipline-name") String disciplineName,
                                @RequestParam(name = "discipline-duration") Integer disciplineDuration){
        disciplineService.addDiscipline(new DisciplineEntity(disciplineName, disciplineDuration));
        return "redirect:/";
    }
}
