package com.example.android1lesson6.model;

import java.io.Serializable;
public class Model implements Serializable {

    private String title;

    public Model (String title){
        this.title = title;
    }

    public String getData(){
        return title;
    }

}
