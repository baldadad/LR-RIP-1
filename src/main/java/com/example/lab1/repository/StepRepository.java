package com.example.lab1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lab1.model.Step;

public interface StepRepository extends JpaRepository<Step, Long> {
}
