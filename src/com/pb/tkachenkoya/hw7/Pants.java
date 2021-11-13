package com.pb.tkachenkoya.hw7;

public class Pants extends Clothes implements ManClothes,WomenClothes{
private String name;
private Size size;
private float coast;
private String color;

    public Pants(String name, Size size, float coast, String color) {
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
        System.out.println(name+" мужские, размер "+ size.name()+ size.toString() +", цена "+ coast+" грн., цвет "+color);
    }

    @Override
    public void dressWomen() {
        System.out.println(name+" женские, размер "+ size.name()+ size.toString() +", цена "+ coast+" грн., цвет "+color);
    }
}
