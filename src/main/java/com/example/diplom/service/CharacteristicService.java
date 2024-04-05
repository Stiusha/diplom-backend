package com.example.diplom.service;

import com.example.diplom.dto.CharacteristicDto;
import com.example.diplom.repositories.CharacteristicRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CharacteristicService {

    private final CharacteristicRepository repository;
    private final ModelMapper mapper;

    public Set<CharacteristicDto> findAllBySubcategoryId(Long subcategoryId) {
        return repository.findAllBySubcategoryId(subcategoryId)
                .stream()
                .map(it -> mapper.map(it, CharacteristicDto.class))
                .collect(Collectors.toSet());
    }
}
