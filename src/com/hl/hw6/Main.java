package com.hl.hw6;

public class Main {
    public static void main(String[] args) {
        Cat catBarsik = new Cat("Барсик");
        Dog dogBobik = new Dog("Бобик");
        Dog dogKuzmich = new Dog("Кузьмич");
        Cat catMursik = new Cat("Мурзик");
        Dog dogBall = new Dog("Шарик");

        catBarsik.run(60.0);
        catMursik.run(300.0);
        catBarsik.swim(10.0);
        dogBall.swim(4.0);
        dogBobik.run(650.0);
        dogKuzmich.swim(12.0);
        System.out.println("   Котов создано " + Cat.getCount() +
                "\n   Собак создано " + Dog.getCount() +
                "\n   Животных создано " + Animal.getCount());

    }
}
