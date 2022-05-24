package com.hl.hw21.task2;

import java.util.ArrayList;

public class GetSale {
    public void getSaleListBook(ArrayList<Product> products, double sale) {

        products.stream()
                .filter(p -> p.type().equals("Book"))
                .filter(p -> p.discount() == true)
                .map(p -> "Product type: "+ p.type()+", sale price "+(p.price()-(p.price()*sale)/100))
                .forEach(s->System.out.println(s));
    }
}
