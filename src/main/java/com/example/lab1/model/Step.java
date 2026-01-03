package com.example.lab1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Step {

    @Id
    @GeneratedValue
    public Long id;

    public int stepNumber;
    public String description;

    @ManyToOne
    @JsonIgnore
    public Recipe recipe;
}
