package com.hl.hw9.star;

import java.util.Random;

public class WordsGame {
    String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    Random random = new Random();
    String hiddenWord = words[random.nextInt(words.length)];

    public boolean wordsGame(String word) {
        if (word.equals(hiddenWord)) {
            System.out.println("You win! This is " + hiddenWord);
            return true;
        } else if (word.charAt(0) == hiddenWord.charAt(0)) {
            for (int count = 1; count < word.length(); count++) {
                if (word.charAt(count) == hiddenWord.charAt(count)) {
                    continue;
                } else if (!(word.charAt(count) == hiddenWord.charAt(count))) {
                    System.out.println((word.codePointCount(0, word.length()) > count ?
                            word.substring(0, word.offsetByCodePoints(0, count)) : word) + "############");
                    return false;
                }
            }
        } else {
            System.out.println("No matches");
            return false;
        }
        return false;
    }
}

