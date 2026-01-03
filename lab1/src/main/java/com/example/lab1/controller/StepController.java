package com.example.lab1.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lab1.model.Recipe;
import com.example.lab1.model.Step;
import com.example.lab1.repository.RecipeRepository;
import com.example.lab1.repository.StepRepository;

@RestController
@RequestMapping("/recipes/{recipeId}/steps")
public class StepController {

    private final StepRepository stepRepo;
    private final RecipeRepository recipeRepo;

    public StepController(StepRepository stepRepo,
                          RecipeRepository recipeRepo) {
        this.stepRepo = stepRepo;
        this.recipeRepo = recipeRepo;
    }

    @PostMapping
    public Step addStep(@PathVariable Long recipeId,
                        @RequestBody Step step) {

        Recipe recipe = recipeRepo.findById(recipeId).orElseThrow();
        step.recipe = recipe;
        return stepRepo.save(step);
    }
}
