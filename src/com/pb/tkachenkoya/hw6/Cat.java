package com.pb.tkachenkoya.hw6;

import java.util.Objects;

public class Cat extends Animal {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getNoise() {
        return noise;
    }

    public void setNoise(String noise) {
        this.noise = noise;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getToy() {
        return toy;
    }

    public void setToy(String toy) {
        this.toy = toy;
    }

    String name = "Кошка";
    String food="рыбу";
    String noise="мяу";
    String location="г.Днепр";
    String toy="mouse";
public Cat(String name, String food, String noise, String location ){
    super();
    this.name=name;
    this.food=food;
    this.noise=noise;
    this.location=location;
}
@Override
public String toString(){
    return "животное "+name+", которая ест: "+food+", проживает в "+location;
}
    @Override
    public String eat(){
        System.out.print("Кошка ест "+ food + ". " );
        return null;
    }
    @Override
    public void makeNoise(){
        System.out.print("Кошка издает звуки: " + noise + "-"+ noise+ ". " );
    }
    @Override
    public void sleep(){
        System.out.print("Кошка спит.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat)) return false;
        Cat cat = (Cat) o;
        return getName().equals(cat.getName()) && getFood().equals(cat.getFood()) && getNoise().equals(cat.getNoise()) && getLocation().equals(cat.getLocation()) && getToy().equals(cat.getToy());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getFood(), getNoise(), getLocation(), getToy());
    }
}
