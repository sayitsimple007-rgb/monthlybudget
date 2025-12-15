package com.example.monthlybudget.api.model;

import java.util.Optional;

public class Expense {
    private int id;
    private String name;
    private int amountDue;
    private int amountPaid;
    private Optional<Country> country;
    private Optional<State> state;
    private Optional<ExpenseType> expenseType;
    public Expense(int id, String name, int amountDue, Optional<Country> country, Optional<State> state, Optional<ExpenseType> expenseType){
        this.id = id;
        this.name = name;
        this.amountDue = amountDue;
        this.country = country;
        this.state = state;
        this.expenseType = expenseType;
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

    public int getAmountDue(){
        return amountDue;
    }

    public void setAmountDue(int amountDue){
        this.amountDue = amountDue;
    }

    public int getAmountPaid(){
        return amountPaid;
    }

    public void setAmountPaid(int amountPaid){
        this.amountPaid = amountPaid;
    }

    public Optional<Country> getCountry(){
        return country;
    }

    public void setCountry(Optional<Country> country){
        this.country = country;
    }

    public Optional<State> getState(){
        return state;
    }

    public void setState(Optional<State> state){
        this.state = state;
    }

    public Optional<ExpenseType> getExpenseType(){
        return expenseType;
    }

    public void setExpenseType(Optional<ExpenseType> expenseType){
        this.expenseType = expenseType;
    }
}
