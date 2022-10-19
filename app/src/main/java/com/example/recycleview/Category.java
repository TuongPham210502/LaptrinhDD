package com.example.recycleview;

import java.util.ArrayList;

public class Category {
    private String nameCategory;
    private ArrayList<Book> books;

    public Category(String nameCategory, ArrayList<Book> phones) {
        this.nameCategory = nameCategory;
        this.books = phones;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public ArrayList<Book> getPhones() {
        return books;
    }

    public void setPhones(ArrayList<Book> phones) {
        this.books = phones;
    }
}
