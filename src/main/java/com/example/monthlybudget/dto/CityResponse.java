package com.example.monthlybudget.dto;

public class CityResponse {
    private Long id;
    private String name;
    private Long countryId;
    private String countryName;
    private Long stateId;
    private String stateName;

    public  CityResponse(Long id, String name, Long countryId, String countryName,
                         Long stateId, String stateName){
        this.id = id;
        this.name = name;
        this.countryId = countryId;
        this.countryName = countryName;
        this.stateId = stateId;
        this.stateName = stateName;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public Long getCountryId() { return countryId; }
    public String getCountryName() { return countryName; }
    public Long getStateId() { return stateId; }
    public String getStateName() { return stateName; }
}
