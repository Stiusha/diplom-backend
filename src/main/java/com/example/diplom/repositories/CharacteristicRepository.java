package com.example.diplom.repositories;

import com.example.diplom.entity.CharacteristicFakeEntity;
import com.example.diplom.entity.CharacteristicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CharacteristicRepository extends JpaRepository<CharacteristicEntity, Long> {

    @Query(value = """
            SELECT
            c.characteristic_id as "characteristicId",
            c.characteristic_name as "characteristicName",
            cv.characteristic_value_id as "characteristicValueId",
            cv.characteristic_value_value as "characteristicValue"
            FROM characteristic c join characteristic_value cv on c.characteristic_id = cv.characteristic_id
            where c.subcategory_id = ?1
            """, nativeQuery = true)
    List<CharacteristicFakeEntity> findFilterBySubcategoryId(Long subcategoryId);

    @Query(value = """
            SELECT * FROM characteristic c
            where c.subcategory_id = ?1
            """, nativeQuery = true)
    List<CharacteristicEntity> findAllBySubcategoryId(Long subcategoryId);
}
