package com.example.diplom.utils;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public enum ProductSort {
    DEFAULT(0, ""),
    CHEAP_TO_EXPENSIVE(1, "order by p.product_price"),
    EXPENSIVE_TO_CHEAP(2, "order by p.product_price desc"),
    BY_RATING(3, "order by p.product_rate desc");

    private static final Map<Integer, ProductSort> codeMap = new HashMap<>();

    static {
        for (ProductSort sort : ProductSort.values()) {
            codeMap.put(sort.code, sort);
        }
    }

    private final int code;

    @Getter
    private final String request;

    ProductSort(int code, String request) {
        this.code = code;
        this.request = request;
    }

    public static ProductSort byCode(Integer code) {
        return codeMap.getOrDefault(code, DEFAULT);
    }
}
