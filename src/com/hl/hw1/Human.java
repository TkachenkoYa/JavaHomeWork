package com.hl.hw1;

import java.util.Objects;

public class Human {

  protected String name;
    protected String surname;
    protected String patronymic;

    public String getName() {
        return name;
    }

    public  String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }
public Human(){

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Human)) return false;
        Human human = (Human) obj;
        return getName().equals(human.getName()) &&
                getSurname().equals(human.getSurname()) &&
                Objects.equals(getPatronymic(), human.getPatronymic());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSurname());
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
