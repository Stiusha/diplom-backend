package com.example.diplom.dto.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterDto {
    private Long subcategoryId;
    private Long minPrice;
    private Long maxPrice;
    private List<FilterKeysDto> filters;
}