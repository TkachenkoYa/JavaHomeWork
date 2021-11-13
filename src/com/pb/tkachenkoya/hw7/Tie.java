package com.pb.tkachenkoya.hw7;

public class Tie extends Clothes implements ManClothes{
    private String name;
    private Size size;
    private float coast;
    private String color;

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

    public Tie(String name, Size size, float coast, String color) {
        this.name = name;
        this.size = size;
        this.coast = coast;
        this.color = color;
    }

    @Override
    public void dressMan() {
        System.out.println("Галстук, размер "+ size.name() + size.toString()+", цена "+ coast+" грн., цвет "+color);
    }
}
