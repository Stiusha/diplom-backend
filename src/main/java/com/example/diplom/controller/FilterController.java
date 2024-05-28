package com.example.diplom.controller;

import com.example.diplom.dto.filter.FilterViewDto;
import com.example.diplom.service.FilterService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/filter")
public class FilterController {

    private final FilterService service;

    @GetMapping(value = "/{subcategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FilterViewDto> findBySubcategoryId(@PathVariable("subcategory") Long subcategory) {
        FilterViewDto filterViewDto = service.findBySubcategoryId(subcategory);
        return ResponseEntity.ok(filterViewDto);
    }
}
