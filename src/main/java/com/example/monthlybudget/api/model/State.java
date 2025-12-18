package com.example.monthlybudget.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "State")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long countryId;
    @Version
    private Long version;

    public State(){

    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public Long getCountryId(){
        return countryId;
    }

    public void setCountryId(Long countryId){
        this.countryId = countryId;
    }

    public Long getVersion(){
        return version;
    }

    public void setVersion(Long version){
        this.version = version;
    }
}
