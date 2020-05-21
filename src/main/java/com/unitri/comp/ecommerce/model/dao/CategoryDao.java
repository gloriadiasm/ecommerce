package com.unitri.comp.ecommerce.model.dao;

import com.unitri.comp.ecommerce.model.entity.Category;

import java.util.List;

public interface CategoryDao {


    Category findById(Long id);

    static void create(Category category) {
    }


    void create(Category category);

    Category update(Category cartItems);

    static void deleteById(int id) {

    }

    void deleteById(int id);

    static List<Category> findAll() {
        return null;
    }

    List<Category> findAll();
}
