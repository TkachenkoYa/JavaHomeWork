package com.pb.tkachenkoya.hw13;

import java.util.ArrayList;
import java.util.List;

public class ProdConsum {
    public static void main(String[] args) {

        Storage storage=new Storage();
        Producer producer = new Producer(storage);
        Consumer consumer = new Consumer(storage);
        new Thread(producer).start();

        new Thread(consumer).start();
    }
}

class Storage{
    List<Integer> product=new ArrayList<>();
    int i=0;
    public synchronized void get() {
        while (product.isEmpty()) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        i--;
        product.remove(i);
        System.out.println("Покупатель купил 1 товар");
        System.out.println("Товаров на складе: " + i);
        System.out.println(product);
        notify();
    }
    public synchronized void put() {

        while (i==5) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        i++;
        product.add(i);
        System.out.println("Производитель добавил 1 товар");
        System.out.println("Товаров на складе: " + i);
        System.out.println(product);
        notify();
    }
}

class Producer implements Runnable{

    Storage storage;
    Producer(Storage storage){
        this.storage=storage;
    }
    public void run(){
        for (int i = 1; i < 6; i++) {
            storage.put();
        }
    }
}

class Consumer implements Runnable{

    Storage storage;
    Consumer(Storage storage){
        this.storage=storage;
    }
    public void run(){
        for (int i = 1; i < 6; i++) {
            storage.get();
        }
    }
}



