package com.hl.hw15.dictionary;

public class Main {
    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();
        fileNavigator.add("/another/path/", new FileData("Commit", 30, "/another/path/"));
        fileNavigator.add("/another/path/", new FileData("NewCommit", 36, "/another/path/"));
        fileNavigator.add("/another/path/", new FileData("SecondCommit", 12, "/another/path/"));
        fileNavigator.add("/path/to/file", new FileData("Push", 31, "/another/path/"));
        fileNavigator.add("/path/to/file", new FileData("PushOne", 22, "/path/to/file"));
        fileNavigator.add("/path/to/file", new FileData("PushTwo", 50, "/path/to/file"));
        fileNavigator.add("/path/to/another", new FileData("Mono", 11, "/path/to/another"));
        fileNavigator.add("/path/to/another", new FileData("Delta", 55, "/path/to/another"));

        System.out.println("Find: " + fileNavigator.find("/path/to/file"));

        System.out.println("Filter by size: " + fileNavigator.filterBySize(20));

        System.out.println("Before remove: " + fileNavigator.toString());
        fileNavigator.remove("/path/to/another");
        System.out.println("After remove: " + fileNavigator);

        System.out.println();

        System.out.println(fileNavigator.sortBySize());

    }
}
