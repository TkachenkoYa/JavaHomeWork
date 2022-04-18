package com.hl.hw15.dictionary;

import java.util.Comparator;

public class FileData {
    private String name;
    private int size;
    private String filePath;

    public FileData(String name, int size, String filePath) {
        this.name = name;
        this.size = size;
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", size=" + size + " bytes" +
                ", filePath='" + filePath + '\'' +
                '}';
    }

    public static final Comparator<FileData> COMPARE_BY_SIZE = new Comparator<FileData>() {
        @Override
        public int compare(FileData o1, FileData o2) {
            return o1.getSize() - o2.getSize();
        }
    };

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public String getFilePath() {
        return filePath;
    }
}
