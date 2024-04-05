package com.example.diplom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacteristicValueDto {
    private Long characteristicId;
    private String characteristicValue;
    private CharacteristicDto characteristic;
}
