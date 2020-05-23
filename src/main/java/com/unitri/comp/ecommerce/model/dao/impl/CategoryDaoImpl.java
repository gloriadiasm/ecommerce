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
    public Category findById(int id){

        Category category = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select *from category where id = "+id);

            while(resultSet.next()) {
                category = new Category(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"));
            }
            statement.close();
            return category;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public Category create(Category category) {

        try {
            PreparedStatement statement = connection.prepareStatement("insert into category(name, description) values(?,?)");
            statement.setString(1, category.getName());
            statement.setString(2, category.getDescription());
            statement.execute();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return category;
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

        List<Category> categories = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select *from category");
            while (resultSet.next()){
                Category category = new Category(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"));
                categories.add(category);
            }
            statement.close();
            return categories;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
