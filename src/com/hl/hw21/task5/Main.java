package com.hl.hw21.task5;


import java.util.ArrayList;

import static java.time.LocalDate.of;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Toy", 90.0, true, of(2022, 10, 15)));
        products.add(new Product("Toy", 35.0, false, of(2019, 2, 5)));
        products.add(new Product("Toy", 10.0, true, of(2021, 10, 15)));
        products.add(new Product("Book", 251.0, false, of(2020, 5, 23)));
        products.add(new Product("Book", 27.9, true, of(2022, 2, 11)));
        products.add(new Product("Book", 50.0, false, of(2022, 3, 1)));
        products.stream().forEach(product -> System.out.println(product));
        CalculatorPrice method = new CalculatorPrice();
        System.out.println("Sum price: " + method.calculatorPrice(products, 75.0));
    }
}
