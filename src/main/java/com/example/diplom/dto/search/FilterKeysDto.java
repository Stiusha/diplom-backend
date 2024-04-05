package com.example.diplom.dto.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterKeysDto {
    private Long characteristicId;
    private List<Long> characteristicValueIds;
}