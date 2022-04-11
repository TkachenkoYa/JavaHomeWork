package com.hl.hw12.phonebook;

import java.util.ArrayList;
import java.util.Objects;

public class Record {
    private String name;
    private ArrayList<String>numbers;

    public Record(String name, ArrayList<String> numbers) {
        this.name = name;
        this.numbers = numbers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<String> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "Record{" +
                "name='" + name + '\'' +
                ", numbers=" + numbers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Record)) return false;
        Record record = (Record) o;
        return Objects.equals(getName(), record.getName()) && Objects.equals(getNumbers(), record.getNumbers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getNumbers());
    }
}
