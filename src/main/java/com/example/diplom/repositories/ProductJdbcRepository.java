package com.example.diplom.repositories;

import com.example.diplom.dto.search.FilterDto;
import com.example.diplom.dto.search.FilterKeyDto;
import com.example.diplom.dto.search.FilterKeysDto;
import com.example.diplom.entity.ProductEntity;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class ProductJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public Set<ProductEntity> filter(FilterDto filter) {
        String pattern = "cv.characteristic_id = %d and pcv.characteristic_value_id = %d";
        String sql = """
                             SELECT p.product_id, p.product_name, p.product_price, p.product_image, p.product_description, p.subcategory_id
                             FROM product p
                             left join product_characteristic_value pcv on p.product_id = pcv.product_id
                             left join characteristic_value cv on pcv.characteristic_value_id = cv.characteristic_value_id
                             where p.subcategory_id =
                             """ + " " + filter.getSubcategoryId() + " ";

        if (filter.getMinPrice() != null && filter.getMinPrice() != 0) {
            sql += "and p.product_price >= " + filter.getMinPrice();
        }

        if (filter.getMaxPrice() != null && filter.getMaxPrice() != 0) {
            sql += "and p.product_price <= " + filter.getMaxPrice();
        }

        List<FilterKeysDto> filters = filter.getFilters();

        System.out.println("FILTER = " + filter);
        if (!filters.isEmpty()) {
            sql += "and (";
            sql += filters.stream().flatMap(keys ->
                            keys.getCharacteristicValueIds().stream().map(key -> new FilterKeyDto(keys.getCharacteristicId(), key))
                    )
                    .map(it -> String.format(pattern, it.getCharacteristicId(), it.getCharacteristicValueId()))
                    .collect(Collectors.joining(" or "));
            sql += ")";
            sql += " group by p.product_id having count(p) = " + filters.size();
        }

        List<ProductEntity> query = jdbcTemplate.query(sql, (rs, rowNum) -> {
            ProductEntity product = new ProductEntity();
            product.setProductId(rs.getLong("product_id"));
            product.setProductName(rs.getString("product_name"));
            product.setProductPrice(rs.getLong("product_price"));
            product.setProductImage(rs.getString("product_image"));
            product.setProductDescription(rs.getString("product_description"));
            return product;
        });

        return new HashSet<>(query);
    }
}
