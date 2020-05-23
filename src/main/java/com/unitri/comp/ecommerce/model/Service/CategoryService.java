package com.unitri.comp.ecommerce.model.service;

import com.unitri.comp.ecommerce.model.dao.CategoryDao;
import com.unitri.comp.ecommerce.model.dao.impl.CategoryDaoImpl;
import com.unitri.comp.ecommerce.model.entity.Category;

import java.sql.SQLException;
import java.util.List;

public class CategoryService {


    final CategoryDao categoryDao = new CategoryDaoImpl();

    public CategoryService() {
    }


    public Category findById(int id) {
        return categoryDao.findById(id);
    }

    public void create(Category category) {
        categoryDao.create(category);
    }

    public void deleteById(int id) throws SQLException {
        categoryDao.deleteById(id);
    }

    public List<Category> findAll() throws SQLException {
        return categoryDao.findAll();
    }
}
