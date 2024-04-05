package com.example.diplom.repositories;

import com.example.diplom.entity.ProductCharacteristicValueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCharacteristicValueRepository extends JpaRepository<ProductCharacteristicValueEntity, Long> {

}
