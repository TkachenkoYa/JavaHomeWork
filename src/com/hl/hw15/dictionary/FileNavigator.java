package com.hl.hw15.dictionary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FileNavigator {
    HashMap<String, ArrayList<FileData>> files = new HashMap<>();

    public void add(String filePath, FileData fileData) {

        if (!filePath.equals(fileData.getFilePath()))
            System.out.println("Error, directory does not match file path " + filePath);

        else if (files.containsKey(filePath) && filePath.equals(fileData.getFilePath()))
            files.get(filePath).add(fileData);

        else if (!files.containsKey(filePath) && filePath.equals(fileData.getFilePath())) {
            files.putIfAbsent(filePath, new ArrayList<>());
            files.get(filePath).add(fileData);
        }
    }

    public ArrayList<FileData> find(String filePath) {
        return files.getOrDefault(filePath, null);
    }

    public ArrayList<FileData> filterBySize(int size) {
        ArrayList<FileData> filterBySize = new ArrayList<>();
        for (Map.Entry<String, ArrayList<FileData>> file : files.entrySet()) {
            for (int j = 0; j < (files.values().size()) - 1; j++) {
                if (file.getValue().get(j).getSize() <= size)
                    filterBySize.add((file.getValue().get(j)));
            }
        }
        return filterBySize;
    }

    @Override
    public String toString() {
        return "files=" + files;
    }

    public void remove(String filePath) {
        files.remove(filePath);
    }

    public ArrayList<FileData> sortBySize() {
        ArrayList<FileData> sortBySize = new ArrayList<>();
        for (Map.Entry<String, ArrayList<FileData>> file : files.entrySet()) {
            for (int j = 0; j < (files.values().size()) - 1; j++) {
                sortBySize.add(file.getValue().get(j));
            }
        }
        Collections.sort(sortBySize, FileData.COMPARE_BY_SIZE);
        return sortBySize;
    }
}
