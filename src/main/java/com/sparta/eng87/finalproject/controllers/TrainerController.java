package com.sparta.eng87.finalproject.controllers;

import com.sparta.eng87.finalproject.entities.TrainerEntity;
import com.sparta.eng87.finalproject.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TrainerController {

    private TrainerService trainerService;

    @Autowired
    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping("/addTrainer")
    public String getAddLocationPage() {
        return "addTrainer";
    }

    @PostMapping("/addTrainer")
    public String addLocation(@RequestParam(name = "trainer-first-name") String firstName,
                              @RequestParam(name = "trainer-last-name") String lastName,
                              @RequestParam(name = "trainer-hex") String hex) {
        TrainerEntity trainerEntity = new TrainerEntity();
        trainerEntity.setFirstName(firstName);
        trainerEntity.setLastName(lastName);
        trainerEntity.setColor(hex);
        trainerService.addTrainer(trainerEntity);
        return "redirect:/trainerPage";
    }

    @GetMapping("/editTrainer/{id}")
    public String editTrainer(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("trainer", trainerService.findTrainerById(id));
        return "editTrainer";
    }

    @PostMapping("/updateTrainer/{id}")
    public String updateTrainer(TrainerEntity trainerEntity,
                                @PathVariable("id") Integer id) {
        trainerEntity.setTrainerId(id);
        trainerService.addTrainer(trainerEntity);
        return "redirect:/trainerPage";
    }

    @GetMapping("/deleteTrainer/{id}")
    public String deleteTrainer(@PathVariable("id") Integer id, Model model) {
        trainerService.deleteTrainer(id);
        model.addAttribute("trainer", trainerService.getAllTrainers());
        return "redirect:/trainerPage";
    }
}
