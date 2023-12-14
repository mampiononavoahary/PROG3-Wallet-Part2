package com.example.Walletpart2.Walletpart2.Repository;

import com.example.Walletpart2.Walletpart2.Database.ConnectDatabase;
import com.example.Walletpart2.Walletpart2.Model.comptes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class SoldeHistoryCrudOperations {
    private static Connection connection;
    public static void getConnection() throws SQLException, ClassNotFoundException {
        ConnectDatabase cdB = new ConnectDatabase();
        connection = cdB.CreateConnection();
    }
    public static void historyOfBalanceOfAccount(LocalDateTime DateDebutHistorique, LocalDateTime DateFinHistorique, comptes compte) throws SQLException, ClassNotFoundException {
        getConnection();
        try{
            String sql = "SELECT soldehistorique.solde FROM soldehistorique \n" +
                    "inner join compte ON soldehistorique.compteId = compte.id \n" +
                    "inner join transactions ON soldehistorique.transactionId = transactions.id \n" +
                    "WHERE compte.id= ? AND transactions.date_de_transactions BETWEEN ? AND ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,compte.getId());
            statement.setObject(2,DateDebutHistorique);
            statement.setObject(3,DateFinHistorique);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Double solde = resultSet.getDouble("balance");
                System.out.println(solde);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
