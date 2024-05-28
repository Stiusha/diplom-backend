package com.example.diplom.controller;

import com.example.diplom.dto.CharacteristicDto;
import com.example.diplom.service.CharacteristicService;
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
@RequestMapping("/characteristics")
public class CharacteristicController {

    private final CharacteristicService service;

    @GetMapping(value = "/{subcategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<CharacteristicDto>> findBySubcategoryId(@PathVariable("subcategory") Long subcategory) {
        Set<CharacteristicDto> characteristics = service.findAllBySubcategoryId(subcategory);
        return ResponseEntity.ok(characteristics);
    }
}
