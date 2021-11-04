package com.pb.tkachenkoya.hw6;

public class Animal {

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    String food;
    String location;
    String noise;

    public String eat(){
         //System.out.print("Животное ест "+ food + ". " );
        return "Животное ест "+ food ;
    }
    public void makeNoise(){
        System.out.print("Животное издает звуки: " + noise + "-"+ noise+ ". " );
    }
    public void sleep(){
        System.out.print("Животное спит.");
    }
}
