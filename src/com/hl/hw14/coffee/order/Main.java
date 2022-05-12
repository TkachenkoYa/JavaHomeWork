package com.hl.hw14.coffee.order;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        Order order1 = new Order("Alen27", 0);
        coffeeOrderBoard.add(order1);
        Order order2 = new Order("Yoda33", 1);
        coffeeOrderBoard.add(order2);
        Order order3 = new Order("Obi-van34", 2);
        coffeeOrderBoard.add(order3);
        Order order4 = new Order("John Snow", 3);
        coffeeOrderBoard.add(order4);

        coffeeOrderBoard.draw();

        Order order5 = new Order("Marry Chris", 4);
        coffeeOrderBoard.add(order5);
        System.out.println("New order from " + order5.getName());
        coffeeOrderBoard.draw();
        System.out.println("Order complete: " + coffeeOrderBoard.deliver());
        coffeeOrderBoard.draw();

        System.out.printf("Order from %s complete", coffeeOrderBoard.deliver(2));
        coffeeOrderBoard.draw();
    }
}
