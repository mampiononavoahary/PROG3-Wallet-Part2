package com.example.Walletpart2.Walletpart2.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    private String url;
    private String user;
    private String password;


    public ConnectDatabase(){
        this.url = System.getenv("DATABASE_URL");
        this.user = System.getenv("DATABASE_USER");
        this.password = System.getenv("DATABASE_PASSWORD");
    }

    public Connection CreateConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");


        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
}
