package com.example.diplom.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubcategoryDto {
    private Long subcategoryId;
    private String subcategoryImage;
    private String subcategoryName;

//    private Set<ProductDto> products;
//    private Set<CharacteristicDto> characteristics;
//    private CategoryDto category;
}
