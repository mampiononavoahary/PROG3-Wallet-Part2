package com.example.Walletpart2.Walletpart2.Repository;

import com.example.Walletpart2.Walletpart2.Database.ConnectDatabase;

import java.sql.Connection;
import java.sql.SQLException;

public class transactionsCrudOperations {
    private static Connection connection;
    public static void getConnection() throws SQLException, ClassNotFoundException {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        connection = connectDatabase.CreateConnection();
    }
}
