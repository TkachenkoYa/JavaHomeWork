package com.pb.tkachenkoya.hw7;

public class Tshirt extends Clothes implements ManClothes,WomenClothes{
    private String name;
    private Size size;
    private float coast;
    private String color;

    public Tshirt(String name, Size size, float coast, String color) {
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
    public void dressMan() {
        System.out.println(name+" мужская, размер "+ size.name()+ size.toString() +", цена "+ coast+" грн., цвет "+color);
    }

    @Override
    public void dressWomen() {
        System.out.println(name+" женская, размер "+ size.name() + size.toString()+", цена "+ coast+" грн., цвет "+color);
    }
}
