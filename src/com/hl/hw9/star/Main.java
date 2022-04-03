package com.hl.hw9.star;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WordsGame wordsGame = new WordsGame();

        System.out.println("Guess the word. It can be a vegetable or fruit");
        System.out.println("Please enter your word:");
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();
        if (word.codePoints().filter(Character::isUpperCase)
                .findFirst().isPresent()) {
            System.out.println("Please, capital letters only");
            word = in.nextLine();
        }
        while (!(wordsGame.wordsGame(word))) {
            System.out.println("Try again");
            word = in.nextLine();
        }
    }
}
