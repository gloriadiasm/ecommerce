package com.unitri.comp.ecommerce.model.entity;

public class Store {

    private int id;
    private String name;
    private int cnpj;
    private int address;

    public Store(int id, String name, int cnpj, int address) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }
}
