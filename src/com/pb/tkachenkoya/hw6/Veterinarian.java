package com.pb.tkachenkoya.hw6;

public class Veterinarian {

    String veterinarian="Ветеринар Петров А.";
       public void treatAnimal(Animal animal){
String string=animal.toString();
        System.out.println(veterinarian +" принимает " + string+".");
    }

}
