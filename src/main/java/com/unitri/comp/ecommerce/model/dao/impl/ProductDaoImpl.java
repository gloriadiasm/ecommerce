package com.unitri.comp.ecommerce.model.dao.impl;

import com.unitri.comp.ecommerce.model.dao.ProductDao;
import com.unitri.comp.ecommerce.model.entity.Product;
import com.unitri.comp.ecommerce.model.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private final Connection connection = new ConnectionFactory().getConnection();

    public ProductDaoImpl() {}

    @Override
    public Product findById(int id) {
        Product product = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from ecommerce.product where id ="+id);
            while(resultSet.next()) {
                product = new Product(resultSet.getInt("id"),
                                      resultSet.getString("name"),
                                      resultSet.getFloat("price"),
                                      resultSet.getString("size"),
                                      resultSet.getInt("category"),
                                      resultSet.getInt("supplier")
                        );
            }
            resultSet.close();
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public Product create(Product product) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into product values (?, ?, ?, ?, ?, ?)");
            statement.setInt(1, product.getId());
            statement.setString(2, product.getName());
            statement.setDouble(3, product.getPrice());
            statement.setString(4, product.getSize());
            statement.setInt(5, product.getCategory());
            statement.setInt(6, product.getSupplier());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void deleteById(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("delete from product where id=?");
            statement.setInt(1, id);
            statement.execute();
            statement.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String sql = "select * from `product`";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                Product product = new Product(resultSet.getInt("id"),
                                              resultSet.getString("name"),
                                              resultSet.getDouble("price"),
                                              resultSet.getString("size"),
                                              resultSet.getInt("category"),
                                              resultSet.getInt("supplier"));
                products.add(product);
            }
            statement.close();
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

}
