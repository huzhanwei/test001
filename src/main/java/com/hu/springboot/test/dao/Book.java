package com.hu.springboot.test.dao;

public class Book {
    private int bookId;
    private String bookName;
    private String bookAuthor;
    private int bookPice;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getBookPice() {
        return bookPice;
    }

    public void setBookPice(int bookPice) {
        this.bookPice = bookPice;
    }
}
