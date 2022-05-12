package com.hl.hw11;

public class Main {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {

        String[][] arrayStrNorm = new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        String[][] arrayStrInvalidVal = new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "x"}
        };
        String[][] arrayStrInvalidSize =new String[][] {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16", "17"}
        };
        ArrayValueCalculator arrayValueCalculator = new ArrayValueCalculator();

        try {
            int sum1 = arrayValueCalculator.doCalc(arrayStrNorm);
            System.out.println("Array sum = " + sum1);
            int sum2 = arrayValueCalculator.doCalc(arrayStrInvalidVal);
            System.out.println("Array sum = " + sum2);
            int sum3 = arrayValueCalculator.doCalc(arrayStrInvalidSize);
            System.out.println("Array sum = " + sum3);
        } catch (MyArraySizeException ex) {
            System.out.println("Size problem: " + ex.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Value problem: " + e.getMessage());
        }
    }
}
