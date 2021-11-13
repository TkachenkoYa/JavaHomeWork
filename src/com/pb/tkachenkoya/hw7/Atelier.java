package com.pb.tkachenkoya.hw7;

public class Atelier {
    public static void main(String[] args) {
        Pants pants1 = new Pants("Брюки", Size.L, (float) 250.7, "синий");
        Pants pants2 = new Pants("Штаны", Size.S, (float) 354.8, "желтый");
        Skirt skirt = new Skirt("Юбка", Size.XS, (float) 218.3, "красный");
        Tie tie = new Tie("Галстук", Size.M, (float) 78.5, "фуксия");
        Tshirt tshirt1 = new Tshirt("Футболка", Size.S, (float) 154.8, "белый");
        Tshirt tshirt2 = new Tshirt("Футболка", Size.XXS, (float) 137.3, "черный");

        Clothes clothes[] = {pants1, pants2, skirt, tie, tshirt1, tshirt2};
        System.out.println("Мужская одежда:");
        dressMan(clothes);
        System.out.println("Женская одежда:");
        dressWomen(clothes);
    }

    static void dressMan(Clothes[] clothes) {
        for (Clothes cloth : clothes) {
            if (cloth instanceof Pants) {
                ((Pants) cloth).dressMan();
            } else if (cloth instanceof Tie) {
                ((Tie) cloth).dressMan();
            }else if (cloth instanceof Tshirt){
                ((Tshirt)cloth).dressMan();
            }
            else {
                continue;
            }
        }
    }

    static void dressWomen(Clothes[] clothes) {
        for (Clothes cloth : clothes) {
            if (cloth instanceof Skirt) {
                ((Skirt) cloth).dressWomen();
            }
            else if (cloth instanceof Pants) {
                    ((Pants) cloth).dressWomen();
            }
            else if (cloth instanceof Tshirt){
                ((Tshirt)cloth).dressWomen();
            }
            else {
                continue;
            }
        }
    }
}