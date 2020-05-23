package com.unitri.comp.ecommerce.model.entity;

public class Product {
    private int id;
    private String name;
    private double price;
    private String size;
    private int category;
    private int supplier;

    public Product(int id, String name, double price, String size, int category, int supplier) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.size = size;
        this.category = category;
        this.supplier = supplier;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getSupplier() {
        return supplier;
    }

    public void setSupplier(int supplier) {
        this.supplier = supplier;
    }
}
