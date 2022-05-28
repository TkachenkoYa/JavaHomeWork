package com.hl.hw21.task4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class GetNewProduct {
    public List<Product> getNewProduct(ArrayList<Product> products) {

        return products.stream()
                .sorted(Comparator.comparing(Product::createDate).reversed())
                .limit(3)
                .toList();
    }
}
