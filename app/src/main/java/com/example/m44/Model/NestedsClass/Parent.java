package com.example.m44.Model.NestedsClass;

import com.example.m44.Model.Product;

import java.util.ArrayList;

public class Parent {
    public String title,title2;
    public ArrayList<Product> listChild;
    public boolean isHorizontal;

    public Parent(String title, String title2, ArrayList<Product> listChild, boolean isHorizontal) {
        this.title = title;
        this.title2 = title2;
        this.listChild = listChild;
        this.isHorizontal=isHorizontal;
    }

    public Parent(String title, String title2, ArrayList<Product> listChild) {
        this.title = title;
        this.title2 = title2;
        this.listChild = listChild;
        this.isHorizontal=true;
    }
    public Parent(ArrayList<Product> listChild,boolean isHorizontal) {
        this.title = "";
        this.title2 = "";
        this.listChild = listChild;
        this.isHorizontal=isHorizontal;
    }
}
