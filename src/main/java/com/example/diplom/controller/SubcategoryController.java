package com.example.diplom.controller;

import com.example.diplom.dto.SubcategoryDto;
import com.example.diplom.entity.SubcategoryEntity;
import com.example.diplom.service.SubcategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/subcategories")
public class SubcategoryController {

    private final SubcategoryService service;

    @GetMapping(value = "/{category}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<SubcategoryDto>> getSubcategories(@PathVariable("category") Long category) {
        Set<SubcategoryDto> subcategories = service.findByCategoryId(category);
        return ResponseEntity.ok(subcategories);
    }
}
