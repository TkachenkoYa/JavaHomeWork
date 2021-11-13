package com.pb.tkachenkoya.hw7;

public class Skirt extends Clothes implements WomenClothes{
    private String name;
    private Size size;
    private float coast;
    private String color;

    public Skirt(String name, Size size, float coast, String color) {
        this.name = name;
        this.size = size;
        this.coast = coast;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Size getSize() {
        return size;
    }

    public float getCoast() {
        return coast;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void dressWomen() {
        System.out.println("Юбка, размер "+ size.name()+ size.toString() +", цена "+ coast+" грн., цвет "+color);
    }
}
