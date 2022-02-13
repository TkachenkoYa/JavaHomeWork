package com.hl.hw1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите фамилию ");
        Human.surname=in.nextLine();
        System.out.println("Введите имя ");
        Human.name=in.nextLine();
        System.out.println("Введите отчество ");
        Human.patronymic=in.nextLine();
        System.out.println("Для вывода выберете: 1-полное ФИО, 2-фамилия, инициалы ");
        String choice = in.nextLine();

        switch (choice) {
            case "1":
                System.out.println(Human.getFullName());
                break;
            case "2":
                System.out.println(Human.getShortName());
                break;
            default:
                System.out.println("Неверный выбор, попробуйте снова");

        }
    }
}
