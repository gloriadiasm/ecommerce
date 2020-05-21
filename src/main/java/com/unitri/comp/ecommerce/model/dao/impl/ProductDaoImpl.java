package com.unitri.comp.ecommerce.model.dao.impl;

import com.unitri.comp.ecommerce.model.dao.ConnectionFactory;
import com.unitri.comp.ecommerce.model.dao.ProductDao;
import com.unitri.comp.ecommerce.model.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private final Connection connection = new ConnectionFactory().getConnection();

    public ProductDaoImpl() throws SQLException {}

    @Override
    public Product findById(Long id) throws SQLException {
        Product product = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from ecommerce.product where id ="+id);
            while(resultSet.next()) {
                product = new Product(resultSet.getLong("id"),
                                      resultSet.getString("name"),
                                      resultSet.getFloat("price"),
                                      resultSet.getString("size"),
                                      resultSet.getLong("category_id"),
                                      resultSet.getLong("supplier_id")
                        );
            }
            resultSet.close();
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return product;
    }

    @Override
    public void create(Product product) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into product values (?, ?, ?, ?, ?, ?)");
            statement.setLong(1, product.getId());
            statement.setString(2, product.getName());
            statement.setFloat(3, product.getPrice());
            statement.setString(4, product.getSize());
            statement.setLong(5, product.getCategory_id());
            statement.setLong(6, product.getSupplier_id());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product product) throws SQLException {
        String sql = "update product set name=?, price=?, size=?, category_id=? where id=?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, product.getName());
            statement.setFloat(2, product.getPrice());
            statement.setString(3, product.getSize());
            statement.setLong(4, product.getCategory_id());
            statement.setLong(5, product.getId());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        try {
            PreparedStatement statement = connection.prepareStatement("delete from product where id=?");
            statement.setLong(1, id);
            statement.execute();
            statement.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() throws SQLException {
        List<Product> products = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String sql = "select * from `product`";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                Product product = new Product(resultSet.getLong("id"),
                                              resultSet.getString("name"),
                                              resultSet.getFloat("price"),
                                              resultSet.getString("size"),
                                              resultSet.getLong("category_id"),
                                              resultSet.getLong("supplier_id"));
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
