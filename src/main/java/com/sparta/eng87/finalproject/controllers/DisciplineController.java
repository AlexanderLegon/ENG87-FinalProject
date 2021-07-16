package com.sparta.eng87.finalproject.controllers;

import com.sparta.eng87.finalproject.entities.DisciplineEntity;
import com.sparta.eng87.finalproject.services.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/edit-discipline/{id}")
    public String updateDiscipline(@PathVariable("id") Integer id, Model model){
        model.addAttribute("discipline", disciplineService.findDisciplineById(id));
        return "editDiscipline";
    }

    @PostMapping("/update-discipline/{id}")
    public String updateDiscipline(DisciplineEntity disciplineEntity, @PathVariable("id") Integer id){
        disciplineEntity.setDiscipline_id(id);
        disciplineService.addDiscipline(disciplineEntity);
        return "redirect:/";
    }

    @PostMapping("/remove-discipline/{id}")
    public String removeDiscipline(DisciplineEntity disciplineEntity, @PathVariable("id") Integer id){
        disciplineService.deleteDiscipline(id);
        return "redirect:/";
    }
}
