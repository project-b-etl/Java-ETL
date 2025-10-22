package com.bootcamp.etl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection() throws SQLException {
        String url = Config.get("db.url");
        String user = Config.get("db.username");
        String password = Config.get("db.password");

        return DriverManager.getConnection(url, user, password);
    }


}