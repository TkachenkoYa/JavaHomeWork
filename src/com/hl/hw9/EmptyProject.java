package com.hl.hw9;

public class EmptyProject {
    public int findSymbolOccurance(String str, char ch) {
        int count = 0;
        char[] chArray = str.toCharArray();
        for (int i = 0; i < chArray.length; i++) {
            if (chArray[i] == ch) {
                count++;
            }
        }
        return count;
    }

    public int findWordPosition(String source, String target) {
        System.out.println("Source: " + source);
        System.out.println("Target: " + target);
        return source.indexOf(target);
    }

    public String stringReverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public boolean isPalindrome(String str) {
        str = str.replaceAll("[^A-Za-zА-Яа-я0-9]", "");
        return str.toLowerCase().equals((new StringBuilder(str)).reverse().toString().toLowerCase());
    }

}
