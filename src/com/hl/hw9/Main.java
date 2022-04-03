package com.hl.hw9;

public class Main {
    public static void main(String[] args) {
        String str = "А роза упала на лапу Азора";
        System.out.println(str);
        EmptyProject emptyProject = new EmptyProject();
        System.out.println(emptyProject.findSymbolOccurance(str, 'а'));
        System.out.println(emptyProject.findWordPosition(str, " роза"));
        System.out.println(emptyProject.stringReverse(str));
        System.out.println(emptyProject.isPalindrome(str));

    }
}
