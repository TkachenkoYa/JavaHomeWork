package com.pb.tkachenkoya.hw6;

import java.util.Objects;

public class Horse extends Animal {
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

    public String getHarness() {
        return harness;
    }

    public void setHarness(String harness) {
        this.harness = harness;
    }

    String name="Лошадка";
    String food="морковь";
    String noise="игого";
    String location="г.Киев";
String harness="упряжь";
    public Horse(String name, String food, String noise, String location ){
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
        System.out.print("Лошадка ест "+ food + ". " );
        return null;
    }
    @Override
    public void makeNoise(){
        System.out.print("Лошадка издает звуки: " + noise + "-"+ noise+ ". " );
    }
    @Override
    public void sleep(){
        System.out.print("Лошадка спит.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Horse)) return false;
        Horse horse = (Horse) o;
        return getName().equals(horse.getName()) && getFood().equals(horse.getFood()) && getNoise().equals(horse.getNoise()) && getLocation().equals(horse.getLocation()) && getHarness().equals(horse.getHarness());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getFood(), getNoise(), getLocation(), getHarness());
    }
}
