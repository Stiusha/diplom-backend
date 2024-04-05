package com.example.diplom.controller;

import com.example.diplom.dto.CategoryDto;
import com.example.diplom.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;


@RestController
@AllArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService service;

    @GetMapping
    public ResponseEntity<Set<CategoryDto>> getCategories() {
        Set<CategoryDto> categories = service.findAll();
        if (categories == null || categories.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(categories);
        }
    }

}