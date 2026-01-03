package com.example.lab1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue
    public Long id;

    @NotBlank
    public String name;
    
    @NotBlank
    public String amount;

    @ManyToOne
    @JsonIgnore
    public Recipe recipe;
}
