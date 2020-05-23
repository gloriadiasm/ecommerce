package com.unitri.comp.ecommerce.model.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ecommerce?useTimezone=true&serverTimezone=UTC", "root", "root1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
