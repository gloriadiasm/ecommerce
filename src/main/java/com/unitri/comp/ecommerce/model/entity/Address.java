package com.unitri.comp.ecommerce.model.entity;

public class Address {
    private Long id;
    private String street;
    private String district;
    private String state;
    private String city;
    private int number;
    private String zipCode;

    public Address(Long id, String street, String district, String state, String city, int number, String zipCode) {
        this.id = id;
        this.street = street;
        this.district = district;
        this.state = state;
        this.city = city;
        this.number = number;
        this.zipCode = zipCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}