package com.hl.hw1;

public class Human {

    protected String name;
    protected String surname;
    protected String patronymic;

    public Human() {
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
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

    public String getFullName() {
        if (patronymic.length() != 0)
            return surname + " " + name + " " + patronymic;
        else
            return surname + " " + name;
    }

    public String getShortName() {
        if (patronymic.length() != 0)
            return surname + " " + name.charAt(0) + "." + patronymic.charAt(0) + ".";
        else
            return surname + " " + name.charAt(0) + ".";
    }


}
