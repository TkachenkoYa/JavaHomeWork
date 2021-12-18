package com.pb.tkachenkoya.hw11;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    private final static long serialVersionUID = 42;
         private String surname;
        private String name;
        private String patronymic;
        private String birthDate;
        private List<Integer> numbers = new ArrayList<>();
        private String address;
        private LocalDate editDate;

    public Person(String surname, String name, String patronymic, String birthDate, List<Integer> numbers, String address, LocalDate editDate) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.numbers = numbers;
        this.address = address;
        this.editDate = editDate;
    }

    public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPatronymic() {
            return patronymic;
        }

        public void setPatronymic(String patronymic) {
            this.patronymic = patronymic;
        }

        public String getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(String birthDate) {
            this.birthDate = birthDate;
        }

        public List<Integer> getNumbers() {
            return numbers;
        }

        public void setNumbers(List<Integer> numbers) {
            this.numbers = numbers;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public LocalDate getEditDate() {
            return editDate;
        }

        public void setEditDate(LocalDate editDate) {
            this.editDate = editDate;
        }


    @Override
    public String toString() {
        return "{" +
                "\"Surname\" : \"" + surname+"\"," + "\n" +
                "\"name\" : \""+name +"\","+ "\n" +
                "\"patronymic\" : \"" + patronymic +"\","+ "\n" +
                "\"birthDate\" : \"" + birthDate +"\","+ "\n" +
                "\"numbers\" : " + numbers +", \n" +
                "\"address\" : \"" + address +"\","+ "\n" +
                "\"editDate\" : \"" + editDate +"\""+ "\n" +
                "}";
    }
}
