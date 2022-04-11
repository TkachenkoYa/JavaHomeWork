package com.hl.hw12.phonebook;

import java.util.ArrayList;
import java.util.List;

public class Phonebook {
    private static ArrayList<Record> records = new ArrayList<>();

    public static ArrayList<Record> getRecords() {
        return records;
    }

    public static void setRecords(ArrayList<Record> records) {
        Phonebook.records = records;
    }

    public static void add(Record record) {
        Phonebook.records.add(record);
    }

    public static Record find(String name) {


        for (int i = 0; i < records.size(); i++) {
            if ((records.get(i).getName().equals(name))) {
                return records.get(i);
            }
        }
        return null;
    }

    public static List<Record> findAll(String name) {
        List<Record> findAll = new ArrayList<>();
        for (int i = 0; i < records.size(); i++) {
            if ((records.get(i).getName()).equals(name)) {
                findAll.add(records.get(i));
            }
        }
        if (!findAll.isEmpty()) {
            return findAll;
        } else return null;
    }
}
