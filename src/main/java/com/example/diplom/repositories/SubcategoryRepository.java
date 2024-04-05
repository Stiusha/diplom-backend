package com.example.diplom.repositories;

import com.example.diplom.entity.SubcategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SubcategoryRepository extends JpaRepository<SubcategoryEntity, Long> {

    @Query(value = "SELECT * FROM subcategory s where s.category_id = ?1", nativeQuery = true)
    Set<SubcategoryEntity> findByCategoryId(Long categoryId);
}
