package com.example.lab1.repository;

import com.example.lab1.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query("""
        select distinct r from Recipe r
        join r.ingredients i
        where lower(i.name) like lower(concat('%', :ingredient, '%'))
    """)
    List<Recipe> findByIngredientName(String ingredient);
}
