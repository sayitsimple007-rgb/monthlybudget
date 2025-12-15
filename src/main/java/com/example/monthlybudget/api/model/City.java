package com.example.monthlybudget.api.model;

public class City {
    private int id;
    private String name;
    private int countryId;
    private int stateId;

    public City(int id, String name, int countryId, int stateId){
        this.id = id;
        this.name = name;
        this.countryId = countryId;
        this.stateId = stateId;
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

    public int getStateId(){
        return stateId;
    }

    public void setStateId(int stateId){
        this.stateId = stateId;
    }
}
