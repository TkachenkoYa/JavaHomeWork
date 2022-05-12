package com.hl.hw12.phonebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.add(new Record("Petrov", new ArrayList<>(Arrays.asList("987123245", "986543845"))));
        phonebook.add(new Record("Petronenko", new ArrayList<>(Arrays.asList("987123254", "986543854"))));
        phonebook.add(new Record("Petrov", new ArrayList<>(Arrays.asList("938763845"))));
        phonebook.add(new Record("Vasin", new ArrayList<>(Arrays.asList("937523245", "934563845"))));
        phonebook.add(new Record("Goroshko", new ArrayList<>(Arrays.asList("687123245", "686543845"))));

        boolean finished = false;
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Телефонный справочник");
            System.out.println("1 - Добавить запись   2 - Поиск по имени  3 - Поиск всех записей по имени");
            System.out.println("0 - Выход");

            String choice = in.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Введите ФИО: ");
                    String tempName = in.nextLine();
                    System.out.println("Введите номера телефонов, после окончания введите end");
                    ArrayList tempNumbers = new ArrayList<>();
                    while (true) {
                        String number = in.nextLine();
                        if (number.equals("end"))
                            break;
                        else tempNumbers.add(number);
                    }
                    phonebook.add(new Record(tempName, tempNumbers));
                    System.out.println("Запись добавлена");
                    break;
                case "2":
                    System.out.println("Введите Фамилию для поиска: ");
                    tempName = in.nextLine();
                    System.out.println(phonebook.find(tempName));
                    break;
                case "3":
                    System.out.println("Введите Фамилию для поиска: ");
                    tempName = in.nextLine();
                    System.out.println(Arrays.asList(phonebook.findAll(tempName)));
                    break;
                case "0":
                    System.out.println("Пока!");
                    finished = true;
                    break;
                default:
                    System.out.println("Неверный выбор, попробуйте снова");
            }
            if (finished) break;
        }
    }
}
