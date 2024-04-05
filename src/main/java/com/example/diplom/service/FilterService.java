package com.example.diplom.service;

import com.example.diplom.dto.filter.FilterItemsDto;
import com.example.diplom.dto.filter.FilterValueDto;
import com.example.diplom.dto.filter.FilterViewDto;
import com.example.diplom.entity.CharacteristicFakeEntity;
import com.example.diplom.entity.FilterPriceFakeEntity;
import com.example.diplom.repositories.CharacteristicRepository;
import com.example.diplom.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Service
@AllArgsConstructor
public class FilterService {

    private final CharacteristicRepository repositoryCharacteristic;
    private final ProductRepository repositoryProduct;

    public FilterViewDto findBySubcategoryId(Long subcategoryId) {
        List<CharacteristicFakeEntity> entities = repositoryCharacteristic.findFilterBySubcategoryId(subcategoryId);
        FilterPriceFakeEntity minMaxPrice = repositoryProduct.findMinMaxPrice(subcategoryId);

        Map<Pair<Long, String>, List<FilterValueDto>> resultMap = entities.stream()
                .collect(groupingBy(entity -> Pair.of(entity.getCharacteristicId(), entity.getCharacteristicName()),
                        mapping(entity -> new FilterValueDto(entity.getCharacteristicValueId(), entity.getCharacteristicValue()), toList())));

        List<FilterItemsDto> filterItemsDto = resultMap.entrySet().stream()
                .map(entry -> new FilterItemsDto(entry.getKey().getFirst(), entry.getKey().getSecond(), entry.getValue()))
                .toList();

        FilterViewDto filterViewDto = new FilterViewDto();
        filterViewDto.setMinPrice(minMaxPrice.getMinProductPrice());
        filterViewDto.setMaxPrice(minMaxPrice.getMaxProductPrice());
        filterViewDto.setFilterItems(filterItemsDto);

        return filterViewDto;
    }

}
