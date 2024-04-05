package com.example.diplom.controller;

import com.example.diplom.dto.ProductDto;
import com.example.diplom.dto.search.FilterDto;
import com.example.diplom.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("productId") Long productId) {
        return service.findByProductId(productId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

//    @GetMapping("/{subcategory}")
//    public ResponseEntity<Set<ProductDto>> getProducts(@PathVariable("subcategory") Long subcategory) {
//        Set<ProductDto> products = service.findBySubcategoryId(subcategory);
//        if (products == null || products.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.ok(products);
//        }
//    }

    @PostMapping
    public ResponseEntity<Set<ProductDto>> filterProducts(@RequestBody FilterDto filter) {
        Set<ProductDto> products = service.filter(filter);
        return ResponseEntity.ok(products);
    }
}
