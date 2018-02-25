package com.example.asus.litepal;

import org.litepal.crud.DataSupport;

/**
 * Created by ASUS on 2018/2/12.
 */

public class Book extends DataSupport{
    private int BookId;
    private String BookName;
    private String author;
    private float price;
    private int pages;
    private int press;
    public Book(){}
    public Book(int bookId, String bookName, String author, float price, int pages, int press) {
        BookId = bookId;
        BookName = bookName;
        this.author = author;
        this.price = price;
        this.pages = pages;
        this.press = press;
    }

    public int getPress() {
        return press;
    }

    public void setPress(int press) {
        this.press = press;
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int bookId) {
        BookId = bookId;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
    public String toString(){
        return "书名："+BookName + " 价格：" + price + "/r/n";
    }
}
