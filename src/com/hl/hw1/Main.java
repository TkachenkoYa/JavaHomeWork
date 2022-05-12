package com.hl.hw1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Human human = new Human();
        System.out.println("Введите фамилию ");
        human.setSurname(in.nextLine());
        System.out.println("Введите имя ");
        human.setName(in.nextLine());
        System.out.println("Введите отчество ");
        human.setPatronymic(in.nextLine());
        System.out.println("Для вывода выберете: 1-полное ФИО, 2-фамилия, инициалы ");
        String choice = in.nextLine();

        switch (choice) {
            case "1":
                System.out.println(human.getFullName());
                break;
            case "2":
                System.out.println(human.getShortName());
                break;
            default:
                System.out.println("Неверный выбор, попробуйте снова");

        }
    }
}
