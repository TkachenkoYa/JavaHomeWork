package com.pb.tkachenkoya.hw5;

public class Library {
    public static void main(String[] args) {
        Reader reader1= new Reader("Петров А.", 123, "Химический",
                2002,982736456);
        Reader reader2= new Reader("Иванов А.", 124, "Математический",
                2001,682736457);
        Reader reader3= new Reader("Иваненко Ф.", 125, "Физический",
                2000,782736453);

        Book book1= new Book("Энциклопедия","Харрис Н.", 2008);
        Book book2= new Book("Spotify наизнанку", "Карлсон С., Лейонхуфвуд Й.", 2021);
        Book book3= new Book("Netflix и культура инноваций", "Маер Э.", 2021);
        Book book4= new Book("Планета Пиксар", "Леви Л.", 2016);
        System.out.println("   Читатели:");
        System.out.println(reader1.getInfo());
        System.out.println(reader2.getInfo());
        System.out.println(reader3.getInfo());
        System.out.println("   Книги:");
        book1.getInfoBook();
        book2.getInfoBook();
        book3.getInfoBook();
        book4.getInfoBook();
        System.out.println();
        reader1.takeBook(book1, book2);
        reader3.takeBook(0,0,book3,book4);
        reader2.takeBook(2,book1,book3,book2);
        System.out.println();
        reader3.returnBook(book4,book3,book1,book2);
        reader1.returnBook(0,0,book1, book2, book3);
        reader2.returnBook(0,book1,book2);
    }
}
