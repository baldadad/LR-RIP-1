package com.example.lab1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lab1.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
