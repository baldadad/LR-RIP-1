package com.example.lab1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lab1.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
