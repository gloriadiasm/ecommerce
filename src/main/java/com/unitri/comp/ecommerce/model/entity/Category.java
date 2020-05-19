package com.unitri.comp.ecommerce.model.entity;

public class Category {
    public Long id;
    public String name;
    public String description;

    public Category(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description= description;;
    }

    public Category() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
