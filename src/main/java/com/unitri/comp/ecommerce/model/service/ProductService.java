package com.unitri.comp.ecommerce.model.service;

import com.unitri.comp.ecommerce.model.dao.ProductDao;
import com.unitri.comp.ecommerce.model.dao.impl.ProductDaoImpl;
import com.unitri.comp.ecommerce.model.entity.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    final ProductDao productDao = new ProductDaoImpl();

    public ProductService() throws SQLException {}

    public Product findById(Long id) throws SQLException {
       return productDao.findById(id);
    }

    public void create(Product product) throws SQLException {
        productDao.create(product);
    }

    public void update(Product product) throws SQLException {
        productDao.update(product);
    }

    public void deleteById(Long id) throws SQLException {
        productDao.deleteById(id);
    }

    public List<Product> findAll() throws SQLException {
        return productDao.findAll();
    }
}
