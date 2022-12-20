package com.example.demo3.connectivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {

    Connection connection;

    public Connection getConnection() {
        String DB_NAME = "user06";
        String DB_USER = "root";
        String DB_PASSWORD = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + DB_NAME, DB_USER, DB_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

}
