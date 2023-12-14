package com.example.Walletpart2.Walletpart2.Service;

import com.example.Walletpart2.Walletpart2.Database.ConnectDatabase;
import com.example.Walletpart2.Walletpart2.Model.TransferHistory;
import com.example.Walletpart2.Walletpart2.Model.comptes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransfertSolde {

    private static Connection connection;
    public static void getConnection() throws SQLException, ClassNotFoundException {
        ConnectDatabase cdb = new ConnectDatabase();
        connection = cdb.CreateConnection();
    }
    public TransferHistory saveTransfertHistory(TransferHistory transfert) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO transfer_history(id,id_compte_crediteur,id_compte_debiteur,valeur,date_de_transfert) VALUES(?,?,?,?,?);";
        getConnection();
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1,transfert.getId());
            statement.setInt(2,transfert.getId_compte_crediteur());
            statement.setInt(3,transfert.getId_compte_debiteur());
            statement.setDouble(4,transfert.getValeur());
            statement.setObject(5,transfert.getDate_de_transfert());

            statement.executeUpdate();
        }
        return null;
    }

    public static Double updateAccoutDebiteur(Double newSolde,int id_compte) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE compte SET solde =? WHERE id_compte;";
        getConnection();
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setDouble(1,newSolde);
            statement.setInt(2,id_compte);

            statement.executeUpdate();
        }
        return null;
    }


}
