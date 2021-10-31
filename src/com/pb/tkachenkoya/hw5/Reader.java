package com.pb.tkachenkoya.hw5;

public class Reader {
    private String name;
    private int numberTicket;
    private String faculty;
    private int date;
    private int phone;


    public Reader(String name, int numberTicket, String faculty, int date, int phone) {
        this.name = name;
        this.numberTicket = numberTicket;
        this.faculty = faculty;
        this.date = date;
        this.phone = phone;
    }

    public int getNumberTicket() {
        return numberTicket;
    }

    public void setNumberTicket(int numberTicket) {
        this.numberTicket = numberTicket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    String getInfo() {
        return name + ", номер читательского билета: " + numberTicket + ", факультет: "
                + faculty + ", год рождения: " + date + ", телефон: " + phone + "]";
    }

    public void takeBook(Book... books) {
        int bookCount = 0;
        for (Book book : books) {
            bookCount++;
        }
        System.out.println(this.name + " взял " + bookCount + " книги.");
    }

    public void takeBook(int bookCount, Book... books) {
        System.out.print(this.name + " взял книги: ");
        bookCount = 1;
        for (Book book : books) {
            System.out.print(book.getNameBook() + " (" + book.getAutorBook()+ ", "+ book.getYear() +" г.)");
             if (bookCount<books.length){
                System.out.print(", ");
                bookCount++;
            }
            else
                System.out.println(".");
        }
    }
public void returnBook (Book... books) {
    int bookCount = 0;
    for (Book book : books) {
        bookCount++;
    }
    System.out.println(this.name + " вернул " + bookCount + " книги.");
}

    public void takeBook(int i, int r, Book... books) {
        System.out.print(this.name + " взял книги: ");
        i =1;
        r=1;
        for (Book book : books) {
            System.out.print(book.getNameBook());
            if (r<books.length){
                System.out.print(", ");
                r=r+i;
            }
            else
            {
                System.out.println(".");
            }
        }
    }
    public void returnBook(int bookCount, Book... books) {
        System.out.print(this.name + " вернул книги: ");
        bookCount = 1;
        for (Book book : books) {
            System.out.print(book.getNameBook() + " (" + book.getAutorBook()+ ", "+ book.getYear() +" г.)");
                if (bookCount<books.length){
                    System.out.print(", ");
                    bookCount++;
                }
                else {
                     System.out.println(".");
                }
        }
    }
    public void returnBook(int i, int r, Book... books) {
        System.out.print(this.name + " вернул книги: ");
        i=0;
        r=1;
        for (Book book : books) {
             System.out.print(book.getNameBook());
            if (r<books.length){
                System.out.print(", ");
                r++;}
            else {
               System.out.println(".");}
               i++;


        }
    }
}

