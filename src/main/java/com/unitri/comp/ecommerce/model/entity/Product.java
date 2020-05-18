package com.unitri.comp.ecommerce.model.entity;

public class Product {
    private Long id;
    private String name;
    private Float price;
    private String size;
    private Long category_id;

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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public Long getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(Long supplier_id) {
        this.supplier_id = supplier_id;
    }

    private Long supplier_id;

    public Product(Long id, String name, Float price, String size, Long category_id, Long supplier_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.size = size;
        this.category_id = category_id;
        this.supplier_id = supplier_id;
    }
}
