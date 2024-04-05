package com.example.diplom.init;

import com.example.diplom.entity.*;
import com.example.diplom.repositories.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
@AllArgsConstructor
public class InitDataBase {

    private final ResourceLoader resourceLoader;
    private final CategoryRepository categoryRepository;
    private final SubcategoryRepository subcategoryRepository;
    private final CharacteristicRepository characteristicRepository;
    private final CharacteristicValueRepository characteristicValueRepository;
    private final ProductRepository productRepository;
    private final ProductCharacteristicValueRepository productCharacteristicValueRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final File categoriesFilePath = new File("sql\\categories.json");
    private final File subcategoriesFilePath = new File("sql\\subcategories.json");
    private final File characteristicsFilePath = new File("sql\\characteristics.json");
    private final File productsFilePath = new File("sql\\products.json");
    private final File characteristicValuesFilePath = new File("sql\\characteristicValues.json");
    private final File productCharacteristicValuesFilePath = new File("sql\\productCharacteristicValues.json");

    @PostConstruct
    private void init() throws IOException {
        CategoryEntity[] categoryEntitiesArray = objectMapper.readValue(
                resourceLoader.getResource("classpath:" + categoriesFilePath).getURL(),
                CategoryEntity[].class);
        categoryRepository.saveAll(List.of(categoryEntitiesArray));

        SubcategoryEntity[] subcategoryEntitiesArray = objectMapper.readValue(
                resourceLoader.getResource("classpath:" + subcategoriesFilePath).getURL(),
                SubcategoryEntity[].class);
        subcategoryRepository.saveAll(List.of(subcategoryEntitiesArray));

        CharacteristicEntity[] characteristicEntitiesArray = objectMapper.readValue(
                resourceLoader.getResource("classpath:" + characteristicsFilePath).getURL(),
                CharacteristicEntity[].class);
        characteristicRepository.saveAll(List.of(characteristicEntitiesArray));

        ProductEntity[] productsEntitiesArray = objectMapper.readValue(
                resourceLoader.getResource("classpath:" + productsFilePath).getURL(),
                ProductEntity[].class);
        productRepository.saveAll(List.of(productsEntitiesArray));

        CharacteristicValueEntity[] characteristicValuesArray = objectMapper.readValue(
                resourceLoader.getResource("classpath:" + characteristicValuesFilePath).getURL(),
                CharacteristicValueEntity[].class);
        characteristicValueRepository.saveAll(List.of(characteristicValuesArray));

        ProductCharacteristicValueEntity[] productCharacteristicValuesArray = objectMapper.readValue(
                resourceLoader.getResource("classpath:" + productCharacteristicValuesFilePath).getURL(),
                ProductCharacteristicValueEntity[].class);
        productCharacteristicValueRepository.saveAll(List.of(productCharacteristicValuesArray));

    }
}