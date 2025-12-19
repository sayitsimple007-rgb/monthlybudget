package com.example.monthlybudget.dto;

public class CurrencyResponse {
    private Long id;
    private String name;
    private Long countryId;
    private String countryName;

    public CurrencyResponse(Long id, String name, Long countryId, String countryName) {
        this.id = id;
        this.name = name;
        this.countryId = countryId;
        this.countryName = countryName;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public Long getCountryId() { return countryId; }
    public String getCountryName() { return countryName; }
}
