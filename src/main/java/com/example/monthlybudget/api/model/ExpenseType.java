package com.example.monthlybudget.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "expense_type")
public class ExpenseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Version
    private Long version;

    public ExpenseType() {

    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Long getVersion(){
        return version;
    }

    public void setVersion(Long version){
        this.version = version;
    }
}
