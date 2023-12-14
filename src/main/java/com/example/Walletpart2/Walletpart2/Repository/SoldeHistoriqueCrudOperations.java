package com.example.Walletpart2.Walletpart2.Repository;

import com.example.Walletpart2.Walletpart2.Database.ConnectDatabase;
import com.example.Walletpart2.Walletpart2.Model.SoldeHistorique;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

}
