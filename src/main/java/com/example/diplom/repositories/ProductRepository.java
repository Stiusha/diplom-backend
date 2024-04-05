package com.example.diplom.repositories;

import com.example.diplom.entity.FilterPriceFakeEntity;
import com.example.diplom.entity.ProductEntity;
import com.example.diplom.entity.SubcategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    @Query(value = """
            SELECT
            min(p.product_price) as "minProductPrice",
            max(p.product_price) as "maxProductPrice"
            FROM product p
            where p.subcategory_id = ?1
            """, nativeQuery = true)
    FilterPriceFakeEntity findMinMaxPrice(Long subcategoryId);

}
