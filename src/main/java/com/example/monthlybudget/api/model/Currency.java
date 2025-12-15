package com.example.monthlybudget.api.model;

public class Currency {
    private int id;
    private String name;
    private int countryId;

    public Currency(int id, String name, int countryId){
        this.id = id;
        this.name = name;
        this.countryId = countryId;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getCountryId(){
        return countryId;
    }

    public void setCountryId(int countryId){
        this.countryId = countryId;
    }
}
