package com.example.monthlybudget.api.model;

public class ExpenseType {
    private int id;
    private String name;
    public ExpenseType(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
