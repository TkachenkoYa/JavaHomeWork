package com.hl.hw14.coffee.order;

import java.util.LinkedList;

public class CoffeeOrderBoard {
    LinkedList<Order> coffeeOrder = new LinkedList<>();

    public void add(Order order) {
        coffeeOrder.addLast(order);
    }

    public Order deliver() {
        Order firstOrder = coffeeOrder.getFirst();
        coffeeOrder.remove(firstOrder);
        return firstOrder;
    }

    public Order deliver(int number) {
        Order completeOrder = coffeeOrder.get(number);
        coffeeOrder.remove(completeOrder);
        return completeOrder;
    }

    public void draw() {
        System.out.print("\n------------------------------------------");
        System.out.print("\n====Coffee will be ready soon...| ");
        for (int i = coffeeOrder.size()-1; i >=0 ; i--) {
            System.out.print(coffeeOrder.get(i).getName() + " | ");
        }
        System.out.println("\n------------------------------------------");
    }
}
