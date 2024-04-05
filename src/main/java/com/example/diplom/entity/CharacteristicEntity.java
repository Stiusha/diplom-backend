package com.example.diplom.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "characteristic")
public class CharacteristicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "characteristic_id")
    private Long characteristicId;

    @Column(name = "characteristic_name")
    private String characteristicName;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "characteristic")
    private Set<CharacteristicValueEntity> characteristic_values;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    private SubcategoryEntity subcategory;
}
