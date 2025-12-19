package com.example.monthlybudget.dto;

public class CityRequest {
    private String name;
    private Long countryId;
    private Long stateId;

    public String getName() {
        return name;
    }

    public Long getCountryId() {
        return countryId;
    }

    public Long getStateId() {
        return stateId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }
}
