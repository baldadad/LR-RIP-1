package com.example.lab1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lab1.model.Ingredient;
import com.example.lab1.model.Recipe;
import com.example.lab1.repository.IngredientRepository;
import com.example.lab1.repository.RecipeRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeRepository recipeRepo;
    private final IngredientRepository ingredientRepo;

    public RecipeController(RecipeRepository recipeRepo, IngredientRepository ingredientRepo) {
        this.recipeRepo = recipeRepo;
        this.ingredientRepo = ingredientRepo;
    }

    @GetMapping
    public List<Recipe> getAll() {
        return recipeRepo.findAll();
    }

    @PostMapping
    public Recipe create(@Valid @RequestBody Recipe recipe) {
        return recipeRepo.save(recipe);
    }

    @PostMapping("/{id}/ingredients")
    public Ingredient addIngredient(@PathVariable Long id, @RequestBody Ingredient ingredient) {

        Recipe recipe = recipeRepo.findById(id).orElseThrow();
        ingredient.recipe = recipe;
        return ingredientRepo.save(ingredient);
    }

    @GetMapping("/search")
    public List<Recipe> searchByIngredient(@RequestParam String ingredient) {
    return recipeRepo.findByIngredientName(ingredient);
    }

    @GetMapping("/{id}/shopping-list")
    public List<String> shoppingList(@PathVariable Long id) {

    Recipe recipe = recipeRepo.findById(id).orElseThrow();

    return recipe.ingredients.stream().map(i -> i.name + " - " + i.amount).toList();
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@PathVariable Long id,
                           @RequestBody Recipe updated) {

    Recipe recipe = recipeRepo.findById(id).orElseThrow();
    recipe.name = updated.name;
    recipe.category = updated.category;

    return recipeRepo.save(recipe);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id) {
    recipeRepo.deleteById(id);
}
}
