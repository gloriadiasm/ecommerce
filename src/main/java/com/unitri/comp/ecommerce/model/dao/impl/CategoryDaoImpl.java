package com.unitri.comp.ecommerce.model.dao.impl;

import com.unitri.comp.ecommerce.model.dao.CategoryDao;
import com.unitri.comp.ecommerce.model.entity.Category;
import com.unitri.comp.ecommerce.model.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    private final Connection connection =  new ConnectionFactory().getConnection();

    public CategoryDaoImpl() {
    }

    @Override
    public Category findById(Long id) {

        Category category = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select *from category where id = "+id);

            while(resultSet.next()) {
                category = new Category(resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getObject("description"));
            }
            statement.close();
            return category;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return category;

    }

    @Override
    public void create(Category category) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into category values(?,?,?)");
            statement.setInt(1, category.getId());
            statement.setString(2, category.getNome());
            statement.setString(3, category.getDescription());
            statement.execute();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public Category update(Category category) {
        return null;
    }

    @Override
    public Category update(Category cartItems) {
        return null;
    }

    @Override
    public void deleteById(int id) {

        try {
            PreparedStatement statement = connection.prepareStatement("delete from category where id=?");
            statement.setInt(1, id);
            statement.execute();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public List<Category> findAll() {
        List<Category> categorys = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String sql = "select *from ´category´";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Category category = new Category(resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getObject("description"));
                category.add(category);
            }
            statement.close();
            return categorys;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categorys;
    }

}
