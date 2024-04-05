package com.example.diplom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCharacteristicValueDto {
    private Long id;
    private ProductDto product;
    private CharacteristicValueDto characteristicValue;
}