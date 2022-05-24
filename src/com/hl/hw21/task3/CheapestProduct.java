package com.hl.hw21.task3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class CheapestProduct {
    public static void getCheapestBook(ArrayList<Product> products) throws Exception {

        Optional<Product> optionalProduct = Optional.ofNullable(products.stream()
                .filter(product -> product.type().equals("Book"))
                .sorted(Comparator.comparingDouble(Product::price))
                .findFirst().orElseThrow(() -> new Exception("Product [Book] not found")));
        System.out.println("Cheapest product type Book: " + optionalProduct);
    }
}
