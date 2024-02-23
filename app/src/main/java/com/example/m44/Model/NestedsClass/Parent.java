package com.example.m44.Model.NestedsClass;

import java.util.ArrayList;

public class Parent {
    public String title,title2;
    public ArrayList<Child> listChild;
    public boolean isHorizontal;

    public Parent(String title, String title2, ArrayList<Child> listChild,boolean isHorizontal) {
        this.title = title;
        this.title2 = title2;
        this.listChild = listChild;
        this.isHorizontal=isHorizontal;
    }

    public Parent(String title, String title2, ArrayList<Child> listChild) {
        this.title = title;
        this.title2 = title2;
        this.listChild = listChild;
        this.isHorizontal=true;
    }
    public Parent(ArrayList<Child> listChild,boolean isHorizontal) {
        this.title = "";
        this.title2 = "";
        this.listChild = listChild;
        this.isHorizontal=isHorizontal;
    }
}
