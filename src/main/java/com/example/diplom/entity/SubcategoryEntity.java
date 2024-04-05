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
@Table(name = "subcategory")
public class SubcategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subcategory_id")
    private Long subcategoryId;

    @Column(name = "subcategory_name")
    private String subcategoryName;

    @Column(name = "subcategory_image")
    private String subcategoryImage;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "subcategory")
    private Set<ProductEntity> products;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "subcategory")
    private Set<CharacteristicEntity> characteristics;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
}
