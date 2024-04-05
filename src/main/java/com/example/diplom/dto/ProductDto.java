package com.example.diplom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long productId;
    private String productName;
    private Long productPrice;
    private Long productRate;
    private String productImage;
    private String productDescription;
//    private SubcategoryDto subcategory;
}
