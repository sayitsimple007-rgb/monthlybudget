package com.example.monthlybudget.api.model;
import jakarta.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long countryId;
    private Long stateId;
    @Version
    private Long version;
    public City() {

    }

    public City(Long id, String name, Long countryId, Long stateId, Long version){
        this.id = id;
        this.name = name;
        this.countryId = countryId;
        this.stateId = stateId;
        this.version = version;
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

    public Long getStateId(){
        return stateId;
    }

    public void setStateId(Long stateId){
        this.stateId = stateId;
    }

    public Long getVersion(){
        return version;
    }

    public void setVersion(Long version){
        this.version = version;
    }
}
