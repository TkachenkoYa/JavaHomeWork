package com.hl.hw21.task1;

import java.util.ArrayList;

public class GetListBook {
    public void getListBook(ArrayList<Product> products) {
        products.stream()
                .filter(product -> product.type().equals("Book"))
                .filter(product -> product.price() > 250.0)
                .forEach(System.out::println);
    }

}
