package com.hl.hw1;

public class Human {

    static String name;
    static String surname;
    static String patronymic;

    public static String getName() {
        return name;
    }

    public static String getSurname() {
        return surname;
    }

    public static String getPatronymic() {
        return patronymic;
    }

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


}
