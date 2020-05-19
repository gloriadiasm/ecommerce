package com.unitri.comp.ecommerce.model.service;



import java.util.List;

public class CategoryService {
    final CategoryDao categoryDao = new CategoryDaoImpl();

    public CategoryService() {
    }

    public Category findById(Long id) {
        return CategoryDao.findById(id);
    }

    public void create(Category category) {
        CategoryDao.create(cart);
    }

    public void deleteById(int id) {
        CategoryDao.deleteById(id);
    }

    public List<Category> findAll() {
        return CategoryDao.findAll();
    }
}