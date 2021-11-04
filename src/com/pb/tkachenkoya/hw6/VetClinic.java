package com.pb.tkachenkoya.hw6;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


public class VetClinic {
    public static void main(String[] args) throws Exception{
        Animal [] animal =new Animal [3];
        animal[0]=new Cat("кошка Люся", "хек", "мрр", "г.Львов");
        animal[1]=new Dog("собака Чарли", "курицу", "тяв", "г.Ужгород");
        animal[2]=new Horse("лошадка Стрела", "свеклу", "пру", "г.Феодосия");

        Class clazz = Class.forName("com.pb.tkachenkoya.hw6.Veterinarian");

        Constructor treatAnimal = clazz.getConstructor(new Class[]{});
        treatAnimal.setAccessible(true);
                Object obj = treatAnimal.newInstance();

        for (int i = 0; i < animal.length; i++)

            ((Veterinarian) obj).treatAnimal(animal[i]);
        }
    }

