package com.hl.hw21.task6;

import java.util.ArrayList;

import static java.time.LocalDate.of;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1,"Toy", 90.0, true, of(2022, 10, 15)));
        products.add(new Product(2,"Toy", 35.0, false, of(2019, 2, 5)));
        products.add(new Product(3,"Toy", 10.0, true, of(2021, 10, 15)));
        products.add(new Product(4,"Book", 251.0, false, of(2020, 5, 23)));
        products.add(new Product(5,"Book", 27.9, true, of(2022, 2, 11)));
        products.add(new Product(6,"Book", 50.0, false, of(2022, 3, 1)));

        GroupProducts method = new GroupProducts();

        System.out.println(method.groupProducts(products));
    }
}
