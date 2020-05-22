package com.unitri.comp.ecommerce.model.dao;

import com.unitri.comp.ecommerce.model.entity.Category;
import java.util.List;

public interface CategoryDao {

    Category findById(Long id);

    void create(Category category);

    Category update(Category cartItems);

    void deleteById(int id);

    List<Category> findAll();
}