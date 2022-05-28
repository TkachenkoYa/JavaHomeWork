package com.hl.hw21.task5;

import java.util.ArrayList;

public class CalculatorPrice {
    public double calculatorPrice (ArrayList<Product> products, double maxPrice){
        return products.stream()
                .filter(p->p.type().equals("Book"))
                .filter(p->p.price()<=maxPrice)
                .filter(p->p.createDate().getYear()==2022)
                .mapToDouble(p->p.price())
                .sum();

    }
}
