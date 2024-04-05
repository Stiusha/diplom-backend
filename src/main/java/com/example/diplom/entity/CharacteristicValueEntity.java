package com.example.diplom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "characteristic_value")
public class CharacteristicValueEntity {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "characteristic_value_id")
    private Long characteristicValueId;

    @Column(name = "characteristic_value_value")
    private String characteristicValue;

    @ManyToOne
    @JoinColumn(name = "characteristic_id")
    private CharacteristicEntity characteristic;

}
