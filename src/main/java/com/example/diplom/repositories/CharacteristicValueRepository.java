package com.example.diplom.repositories;

import com.example.diplom.entity.CharacteristicValueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacteristicValueRepository extends JpaRepository<CharacteristicValueEntity, Long> {

}
