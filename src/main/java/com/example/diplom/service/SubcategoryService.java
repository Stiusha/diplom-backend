package com.example.diplom.service;

import com.example.diplom.dto.SubcategoryDto;
import com.example.diplom.repositories.SubcategoryRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SubcategoryService {

    private final SubcategoryRepository repository;
    private final ModelMapper mapper;

    public Set<SubcategoryDto> findByCategoryId(Long category) {
        return repository.findByCategoryId(category).stream()
                .map(it -> mapper.map(it, SubcategoryDto.class))
                .collect(Collectors.toSet());
    }

}
