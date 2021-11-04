package com.pb.tkachenkoya.hw6;

import java.util.Objects;

public class Dog extends Animal {
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

    public String getAccessory() {
        return accessory;
    }

    public void setAccessory(String accessory) {
        this.accessory = accessory;
    }

    String name = "Собака";
    String food = "мясо";
    String noise="гав";
    String location="г.Одесса";
    String accessory="шлейка";
    public Dog(String name, String food, String noise, String location ){
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
        System.out.print("Собака ест "+ food + ". " );
        return null;
    }
    @Override
    public void makeNoise(){
        System.out.print("Собака издает звуки: " + noise + "-"+ noise+ ". " );
    }
    @Override
    public void sleep(){
        System.out.print("Собака спит.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dog)) return false;
        Dog dog = (Dog) o;
        return getName().equals(dog.getName()) && getFood().equals(dog.getFood()) && getNoise().equals(dog.getNoise()) && getLocation().equals(dog.getLocation()) && getAccessory().equals(dog.getAccessory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getFood(), getNoise(), getLocation(), getAccessory());
    }
}
