package com.unitri.comp.ecommerce.model.entity;

public class Supplier {
    private Long id;
    private String name;
    private Long address_id;

    public Supplier(Long id, String name, Long address_id) {
        this.id = id;
        this.name = name;
        this.address_id = address_id;
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

    public Long getAddress() {
        return address_id;
    }

    public void setAddress(Long address_id) {
        this.address_id = address_id;
    }

}
