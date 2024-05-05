package com.example.diplom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.ResultSet;
import java.sql.SQLException;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private Long productPrice;

    @Column(name = "product_rate")
    private Long productRate;

    @Column(name = "product_image")
    private String productImage;

    @Column(name = "product_description")
    private String productDescription;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    private SubcategoryEntity subcategory;

    public static ProductEntity byResultSet(ResultSet rs) throws SQLException {
        ProductEntity product = new ProductEntity();
        product.setProductId(rs.getLong("product_id"));
        product.setProductName(rs.getString("product_name"));
        product.setProductPrice(rs.getLong("product_price"));
        product.setProductRate(rs.getLong("product_rate"));
        product.setProductImage(rs.getString("product_image"));
        product.setProductDescription(rs.getString("product_description"));
        return product;
    }
}
