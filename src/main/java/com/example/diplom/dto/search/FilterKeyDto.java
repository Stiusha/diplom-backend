package com.example.diplom.dto.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterKeyDto {
    private Long characteristicId;
    private Long characteristicValueId;
}