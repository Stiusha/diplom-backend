package com.example.diplom.dto.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterValueDto {
    private Long characteristicValueId;
    private String characteristicValue;
}
