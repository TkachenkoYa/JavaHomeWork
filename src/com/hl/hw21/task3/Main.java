package com.hl.hw21.task3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Toy", 100.0, true));
        products.add(new Product("Toy", 350.0, false));
        products.add(new Product("Toy", 10.0, true));
        products.add(new Product("Book", 251.0, false));
        products.add(new Product("Book", 279.0, true));
        products.add(new Product("Book", 150.0, false));
        products.stream().forEach(product -> System.out.println(product));
        CheapestProduct method = new CheapestProduct();
        method.getCheapestBook(products);
    }
}
