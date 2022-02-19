package com.hl.hw3_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите ФИО ");
        String fio = in.nextLine();
        Person person = new Person(fio);
        System.out.printf("%s\n %s\n %s", person.getSurname(), person.getName(), person.getPatronymic());

    }
}
