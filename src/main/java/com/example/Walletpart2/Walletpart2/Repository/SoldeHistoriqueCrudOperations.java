package com.example.Walletpart2.Walletpart2.Repository;

import com.example.Walletpart2.Walletpart2.Database.ConnectDatabase;
import com.example.Walletpart2.Walletpart2.Model.SoldeHistorique;
import com.example.Walletpart2.Walletpart2.Model.comptes;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SoldeHistoriqueCrudOperations {
    private static Connection connection;
    public static void getConnection() throws SQLException, ClassNotFoundException {
        ConnectDatabase cdB = new ConnectDatabase();
        connection = cdB.CreateConnection();
    }
    public SoldeHistorique extract(ResultSet resultSet) throws SQLException {
        LocalDateTime date = resultSet.getTimestamp("date_de_transactions").toLocalDateTime();
        Double montant = resultSet.getDouble("montant") ;
        return new SoldeHistorique(date,montant);
    }
    public List<SoldeHistorique> listSoldeWithDate(int id) throws SQLException, ClassNotFoundException {
        List<SoldeHistorique> soldeHistoriques = new ArrayList<>();
        String sql = "SELECT \n"+
                " transactions.date_de_transactions, \n"+
                " SUM(transactions.montant) OVER(PARTITION BY transactions.id_compte ORDER BY transactions.date_de_transactions) AS montant\n"+
                " FROM transactions WHERE transactions.id_compte=?";

        getConnection();
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                SoldeHistorique soldeHistory = extract(resultSet);

                soldeHistoriques.add(soldeHistory);
            }
            for (SoldeHistorique solde: soldeHistoriques){
                System.out.println("the list of solde with date: "+ solde);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return soldeHistoriques;
    }
    public void historyOfBalanceOfAccount(int id_compte, Timestamp DateDebutHistorique, Timestamp DateFinHistorique) throws SQLException, ClassNotFoundException {
        getConnection();
        try{
            String sql = "SELECT soldehistorique.solde FROM soldehistorique \n" +
                    "inner join compte ON soldehistorique.compteId = compte.id \n" +
                    "inner join transactions ON soldehistorique.transactionId = transactions.id \n" +
                    "WHERE compte.id= ? AND transactions.date_de_transactions BETWEEN ? AND ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id_compte);
            statement.setTimestamp(2,DateDebutHistorique);
            statement.setTimestamp(3,DateFinHistorique);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Double solde = resultSet.getDouble("solde");
                System.out.println("Historique solde transfert: "+solde);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
