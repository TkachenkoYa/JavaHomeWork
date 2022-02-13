package com.hl.hw1;

import java.util.Scanner;

public class Human {

    private static String name;
    private static String surname;
    private static String patronymic;

    public Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Human(String name, String surname, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public static String getFullName() {
        if (patronymic.length() != 0)
            return surname + " " + name + " " + patronymic;
        else
            return surname + " " + name;
    }

    public static String getShortName() {
        if (patronymic.length() != 0)
            return surname + " " + name.charAt(0) + "." + patronymic.charAt(0) + ".";
        else
            return surname + " " + name.charAt(0) + ".";
    }

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
