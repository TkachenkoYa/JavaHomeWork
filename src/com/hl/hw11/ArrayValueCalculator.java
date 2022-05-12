package com.hl.hw11;

public class ArrayValueCalculator {

    public static int doCalc(String[][] arrayStr) throws MyArraySizeException, MyArrayDataException, NumberFormatException {
        int sum = 0;
        if (arrayStr.length != 4) throw new MyArraySizeException("Invalid array size", arrayStr.length);

        for (int i = 0; i < arrayStr.length; i++) {
            String[] val = arrayStr[i];
            for (int j = 0; j < val.length; j++) {
                if (val.length != 4)
                    throw new MyArraySizeException("Invalid inner", arrayStr.length);

                try {
                    sum += Integer.parseInt(val[j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Invalid element value", val[j], i, j);
                }
            }
        }
        return sum;
    }
}
