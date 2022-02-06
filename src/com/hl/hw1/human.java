package com.hl.hw1;

import java.util.Scanner;

public class human {
    private static String name;
    private static String surname;
    private static String patronymic;

    public human(String name, String surname) {
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

    public human(String name, String surname, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public static void getFullName() {
        if (patronymic.length()!=0)
            System.out.println("ФИО " + surname + " " + name + " " + patronymic);
        else
            System.out.println("ФИО " + surname + " " + name);
    }

    public static void getShortName() {
        if (patronymic.length()!=0)
            System.out.println("Фамилия, инициалы " + surname + " " + name.charAt(0) + "." + patronymic.charAt(0)+ ".");
        else
            System.out.println("Фамилия, инициалы " + surname + " " + name.charAt(0)+ ".");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        System.out.println("Введите фамилию ");
        human.surname = in.nextLine();
        System.out.println("Введите имя ");
        human.name = in.nextLine();
        System.out.println("Введите отчество ");
        human.patronymic = in.nextLine();
        System.out.println("Для вывода выберете: 1-полное ФИО, 2-фамилия, инициалы ");
        String choice = in.nextLine();

        switch (choice) {
            case "1":
                getFullName();
                break;
            case "2":
                getShortName();
                break;
            default:
                System.out.println("Неверный выбор, попробуйте снова");

    }
}}
