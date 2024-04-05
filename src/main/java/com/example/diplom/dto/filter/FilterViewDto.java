package com.example.diplom.dto.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterViewDto {
    private Long minPrice;
    private Long maxPrice;
    private List<FilterItemsDto> filterItems;
}
