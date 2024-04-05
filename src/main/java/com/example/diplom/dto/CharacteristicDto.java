package com.example.diplom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacteristicDto {
    private Long characteristicId;
    private String characteristicName;
//    private Set<CharacteristicValueDto> characteristic_values;
//    private SubcategoryDto subcategory;
}
