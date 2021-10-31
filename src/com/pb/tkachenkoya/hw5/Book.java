package com.pb.tkachenkoya.hw5;

public class Book {

        private static int bookCount = 0;

        public static int getBookCount() {
            return bookCount;
        }

        private String nameBook;
        private String autorBook;
        private int year;

        public Book (String nameBook, String autorBook, int year){
                this.nameBook=nameBook;
                this.autorBook=autorBook;
                this.year=year;
                bookCount++;
        }
        public void getInfoBook (){
        System.out.println(nameBook + " (" + autorBook+ ", "+ year +" г.)");
}
        public String getNameBook() {
                return nameBook;
        }

        public void setNameBook(String nameBook) {
                this.nameBook = nameBook;
        }

        public String getAutorBook() {
                return autorBook;
        }

        public void setAutorBook(String autorBook) {
                this.autorBook = autorBook;
        }

        public int getYear() {
                return year;
        }

        public void setYear(int year) {
                this.year = year;
        }
}
