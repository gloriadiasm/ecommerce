package com.unitri.comp.ecommerce.model.entity;

public class Address {
    private int id;
    private String street;
    private String district;
    private String state;
    private String city;
    private int number;
    private String zip_code;

    public Address(int id, String street, String district, String state, String city, int number, String zip_code) {
        this.id = id;
        this.street = street;
        this.district = district;
        this.state = state;
        this.city = city;
        this.number = number;
        this.zip_code = zip_code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }
}