package com.example.asus.litepal;

import org.litepal.crud.DataSupport;

/**
 * Created by ASUS on 2018/2/12.
 */

public class Category extends DataSupport{
    private String Name;
    private int Category_code;

    public Category() {
    }

    public String getName() {
        return Name;
    }

    public Category(String name, int category_code) {
        Name = name;
        Category_code = category_code;
    }

    public void setName(String name) {

        Name = name;
    }

    public int getCategory_code() {
        return Category_code;
    }

    public void setCategory_code(int category_code) {
        Category_code = category_code;
    }
}
