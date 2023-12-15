package com.example.Walletpart2.Walletpart2.Repository;

import com.example.Walletpart2.Walletpart2.Database.ConnectDatabase;
import com.example.Walletpart2.Walletpart2.Model.Categorie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetCategorie {
    private static Connection connection;
    public static void getConnection() throws SQLException, ClassNotFoundException {
        ConnectDatabase cdb = new ConnectDatabase();
        connection = cdb.CreateConnection();
    }
    public static String CategorieList(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT type FROM categorie where id=?";
        getConnection();
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                return resultSet.getString("type");
            }

        }
        return null;
    }
}
