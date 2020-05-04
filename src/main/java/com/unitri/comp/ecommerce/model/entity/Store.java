package com.unitri.comp.ecommerce.model.entity;

public class Store {

    private Long id;
    private String name;
    private Long cnpj;
    private String addresses;
    private Long sold_id;
    private Long stock_id;

    public Store(Long id, String name, Long cnpj, String addresses, Long sold_id, Long stock_id) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.addresses = addresses;
        this.sold_id = sold_id;
        this.stock_id = stock_id;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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

    public Long getSold_id() {
        return sold_id;
    }

    public void setSold_id(Long sold_id) {
        this.sold_id = sold_id;
    }

    public Long getStock_id() {
        return stock_id;
    }

    public void setStock_id(Long stock_id) {
        this.stock_id = stock_id;
    }
}
