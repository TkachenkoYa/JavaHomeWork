package com.hl.hw21.task1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product>products=new ArrayList<Product>();
        products.add(new Product("Toy",100.0));
        products.add(new Product("Toy",350.0));
        products.add(new Product("Toy",10.0));
        products.add(new Product("Book",251.0));
        products.add(new Product("Book",279.0));
        products.add(new Product("Book",150.0));
        GetListBook method=new GetListBook();
method.getListBook(products);

    }
}
