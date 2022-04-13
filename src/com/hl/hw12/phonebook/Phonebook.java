package com.hl.hw12.phonebook;

import java.util.ArrayList;
import java.util.List;

public class Phonebook {
    private ArrayList<Record> records = new ArrayList<>();

    public void add(Record record) {
        records.add(record);
    }

    public Record find(String name) {
        for (int i = 0; i < records.size(); i++) {
            if ((records.get(i).getName().equals(name)))
                return records.get(i);
        }
        return null;
    }

    public List<Record> findAll(String name) {
        List<Record> findAll = new ArrayList<>();
        for (int i = 0; i < records.size(); i++) {
            if ((records.get(i).getName()).equals(name))
                findAll.add(records.get(i));
        }
        if (!findAll.isEmpty())
            return findAll;
        else return null;
    }
}
