package com.example.diplom.service;

import com.example.diplom.dto.ProductDto;
import com.example.diplom.dto.search.FilterDto;
import com.example.diplom.entity.FilterPriceFakeEntity;
import com.example.diplom.repositories.ProductJdbcRepository;
import com.example.diplom.repositories.ProductRepository;
import com.example.diplom.utils.ProductSort;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ProductJdbcRepository jdbcRepository;
    private final ModelMapper mapper;

    public Optional<ProductDto> findByProductId(Long product_id) {
        return repository.findById(product_id).map(productEntity -> mapper.map(productEntity, ProductDto.class));
    }

    public List<ProductDto> filter(FilterDto filterDto, ProductSort sort) {
        return jdbcRepository.filter(filterDto, sort).stream()
                .map(it -> mapper.map(it, ProductDto.class))
                .collect(Collectors.toList());
    }

}
