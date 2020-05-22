package com.unitri.comp.ecommerce.model.entity;

public class Store {

    private int id;
    private String name;
    private Long cnpj;
    private String addresses;
    private int sold_id;
    private int stock_id;

    public Store(int id, String name, Long cnpj, String addresses, int sold_id, int stock_id) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.addresses = addresses;
        this.sold_id = sold_id;
        this.stock_id = stock_id;
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

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public String getAddresses() {
        return addresses;
    }

    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }

    public int getSold_id() {
        return sold_id;
    }

    public void setSold_id(int sold_id) {
        this.sold_id = sold_id;
    }

    public int getStock_id() {
        return stock_id;
    }

    public void setStock_id(int stock_id) {
        this.stock_id = stock_id;
    }

}
