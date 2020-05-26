package com.unitri.comp.ecommerce.model.dao.impl;

import com.unitri.comp.ecommerce.model.dao.ConnectionFactory;
import com.unitri.comp.ecommerce.model.dao.SoldDao;
import com.unitri.comp.ecommerce.model.entity.Sold;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SoldDaoImpl implements SoldDao {

    private final Connection connection;

    public SoldDaoImpl() throws SQLException {
        this.connection =  new ConnectionFactory().getConnection();
    }

    @Override
    public Sold findById(int id) throws SQLException {

        Sold sold = null;
        String sql = "select * from sold where id = ?";


        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();

            resultSet.next();

            sold = new Sold(resultSet.getInt("id"),
                    resultSet.getInt("product_id"),
                    resultSet.getInt("quantity"),
                    resultSet.getDouble("price"));

            resultSet.close();
            stmt.close();
            return sold;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sold;
    }

    @Override
    public Sold create(Sold sold) throws SQLException {

        String sql = "insert into sold(product_id, quantity, price) values (?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, sold.getProduct_id());
            stmt.setInt(2, sold.getQuantity());
            stmt.setDouble(3, sold.getPrice());

            stmt.execute();
            stmt.close();

            return null;

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }
    }

    @Override
    public Sold update(Sold sold) throws SQLException {

        String sql = "update sold set product_id =?, quantity=?, price=? where id =?";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            stmt.setInt(1,sold.getProduct_id());
            stmt.setInt(2, sold.getQuantity());
            stmt.setDouble(3, sold.getPrice());
            stmt.setInt(4, sold.getId());

            stmt.execute();
            stmt.close();

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(Sold sold) throws SQLException {

        String sql = "delete from sold where id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            stmt.setInt(1, sold.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteById(int id) throws SQLException {
        String sql = "delete from sold where id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Sold> findAll() throws SQLException {

        String sql = "select * from sold";

        try {
            List<Sold> solds = new ArrayList<Sold>();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);



            while (resultSet.next()) {

                Sold sold = new Sold(resultSet.getInt("id"),
                        resultSet.getInt("product_id"),
                        resultSet.getInt("quantity"),
                        resultSet.getDouble("price"));

                solds.add(sold);
            }

            resultSet.close();
            statement.close();

            return solds;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
