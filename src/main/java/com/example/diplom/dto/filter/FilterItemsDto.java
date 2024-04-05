package com.example.diplom.dto.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterItemsDto {
    private Long characteristicId;
    private String characteristicName;
    private List<FilterValueDto> characteristicValues;
}
