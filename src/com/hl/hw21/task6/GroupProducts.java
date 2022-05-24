package com.hl.hw21.task6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupProducts {
    public Map<String, List<Product>> groupProducts(ArrayList<Product> products) {
       return products.stream()
                .collect(Collectors.groupingBy(Product::type));
    }
}
