package com.pb.tkachenkoya.hw10;

public class NumBox <T extends Number> {
    public T getNumber (int index) {
        return number[index];
    }

    private T[] number;

    public NumBox(int size) {
        number = (T[]) new Number[size];

    }
public int length(){
        return number.length;
}
    public void add(int index, T num) throws ArrayIndexOutOfBoundsException {
        try {
//                    if (index<= number.length)
//                    number[index] = num;
//                    else throw new ArrayIndexOutOfBoundsException("Массив переполнен");
      if (index > number.length) {
         throw new ArrayIndexOutOfBoundsException("Массив переполнен");
       } else number[index] = num;
            } catch (NullPointerException e) {
            e.getMessage();
        }
        catch (ArrayIndexOutOfBoundsException ex){
            System.out.println(ex.getMessage());
        }
    }
    public int lengthNow() {
        int length = 0;
        try {
            for (T numbers : number) {
                if (numbers.equals(null))
                    return length;
                else length++;
            }
        } catch (NullPointerException e) {
            e.getMessage();
        }return length;
    }

    double sum()  {
        double sum = 0;
        try {

        for (T numbers : number) {
            if (numbers.equals(null))
                return sum;
            else sum += numbers.doubleValue();
        }
        }
        catch (NullPointerException e){
            e.getMessage();
        }return sum;
    }
    double average() {
        double average = 0;
        try {
                    average = sum() / lengthNow();
                    return average;
        } catch (NullPointerException e) {
            e.getMessage();
        }return average;
    }
    public T max () {
        int maxInd=0;
        double maxNum=0;
            try {
                if (lengthNow() == 0) {
                    System.out.println("Массив пуст");
                } else if (number!=null){
                    for (int i = 0;i<lengthNow();i++) {
                        for (int j = lengthNow()-1;j > i; j--) {
                            if (number[j].doubleValue() >= maxNum) {
                                maxInd = j;
                                maxNum=number[j].doubleValue();
                            } }} } } catch (NullPointerException e) {
                e.getMessage();            }
        return number[maxInd];
    }

//        public double max () {
//            double max = 0;
//            try {
//                if (number.length == 0) {
//                    System.out.println("Массив пуст");
//                } else {
//                    for (T numbers : number) {
//                        if (numbers.doubleValue() >= max) {
//                            max = numbers.doubleValue();
//                        } else if (numbers.equals(null)) {
//                            return max;
//                        } else return max;
//                    }
//                }
//                return max;
//            } catch (NullPointerException e) {
//                e.getMessage();
//            }
//            return max;
//        }
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException{
        int sizeF=3;
        int sizeI=4;
            NumBox numberF = new NumBox<Float>(sizeF);
            NumBox numberI = new NumBox<Integer>(sizeI);
try {

    numberF.add(0,2.5f);
    numberF.add(1,2.9f);
    numberF.add(2,3.4f);
    //numberF.add(3,2.3f);
    System.out.println("    Дробный массив: ");
            System.out.println("Элемент в ячейке 1: "+numberF.getNumber(1));
            System.out.println("Текущая длина массива: "+numberF.lengthNow());
            System.out.println("Среднее значение элементов: " + String.format("%.2f",numberF.average()));
            System.out.println("Сумма элементов: " + String.format("%.2f",numberF.sum()));
            System.out.println("Максимальный элемент: " + numberF.max());
    numberI.add(0,2);
    numberI.add(1,9);
    numberI.add(2,3);
    //numberI.add(3,5);
    System.out.println("     Целочисленный массив: ");
            System.out.println("Элемент в ячейке 3: "+numberI.getNumber(3));
            System.out.println("Текущая длина массива: "+numberI.lengthNow());
            System.out.println("Среднее значение элементов: " + String.format("%.2f",numberI.average()));
            System.out.println("Сумма элементов: " + numberI.sum());
            System.out.println("Максимальный элемент: " + numberI.max());
        }
catch (ArrayIndexOutOfBoundsException e){
    e.getMessage();
}
    }
}
