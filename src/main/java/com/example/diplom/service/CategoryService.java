package com.example.diplom.service;

import com.example.diplom.dto.CategoryDto;
import com.example.diplom.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;
    private final ModelMapper mapper;

    public Set<CategoryDto> findAll() {
        return repository.findAll().stream()
                .map(it -> mapper.map(it, CategoryDto.class))
                .collect(Collectors.toSet());
    }
}
