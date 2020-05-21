package com.unitri.comp.ecommerce.model.service;



import com.unitri.comp.ecommerce.model.dao.CategoryDao;
import com.unitri.comp.ecommerce.model.dao.impl.CategoryDaoImpl;
import com.unitri.comp.ecommerce.model.entity.Category;

import java.util.List;

public class CategoryService {
    final CategoryDao categoryDao = new CategoryDao() {
        @Override
        public Category update(Category cartItems) {
            return null;
        }
    };

    public CategoryService() {
    }

    public void create(Category category) {
        CategoryDao.create(category);
    }

    public void deleteById(int id) {
        CategoryDao.deleteById(id);
    }

    public List<Category> findAll() {
        return CategoryDao.findAll();
    }
}
