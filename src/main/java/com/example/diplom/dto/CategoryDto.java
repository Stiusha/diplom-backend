package com.example.diplom.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Long categoryId;
    private String categoryImage;
    private String categoryName;
//    private Set<SubcategoryEntity> subcategories.json;
}
