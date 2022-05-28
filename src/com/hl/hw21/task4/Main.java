package com.hl.hw21.task4;

import java.util.ArrayList;

import static java.time.LocalDate.of;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Toy", 100.0, true, of(2022, 10, 15)));
        products.add(new Product("Toy", 350.0, false, of(2022, 2, 5)));
        products.add(new Product("Toy", 10.0, true, of(2021, 10, 15)));
        products.add(new Product("Book", 251.0, false, of(2020, 5, 23)));
        products.add(new Product("Book", 279.0, true, of(2021, 2, 11)));
        products.add(new Product("Book", 150.0, false, of(2019, 3, 1)));
        products.stream().forEach(product -> System.out.println(product));
        GetNewProduct method = new GetNewProduct();
        System.out.println(method.getNewProduct(products));
    }
}
