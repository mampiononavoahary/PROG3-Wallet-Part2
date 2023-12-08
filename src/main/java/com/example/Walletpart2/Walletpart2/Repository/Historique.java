package com.example.Walletpart2.Walletpart2.Repository;

import com.example.Walletpart2.Walletpart2.Database.ConnectDatabase;
import com.example.Walletpart2.Walletpart2.Model.transactions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Historique {
    private static Connection connection;
    public static void getConnection() throws SQLException, ClassNotFoundException {
        ConnectDatabase cdB = new ConnectDatabase();
        connection = cdB.CreateConnection();
    }

    public static void registerTransactionHistory(transactions debiteur, transactions crediteur) throws SQLException, ClassNotFoundException {
        getConnection();
        try{
            String sql = "insert into Transfer_history (id,id_transaction_debiteur,id_transaction_crediteur,date_de_transactions) values (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,crediteur.getId());
            statement.setInt(2,debiteur.getId());
            statement.setObject(3,crediteur.getDate_de_transactions());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
