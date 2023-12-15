package com.example.Walletpart2.Walletpart2.Service;

import com.example.Walletpart2.Walletpart2.Database.ConnectDatabase;

import java.sql.*;

public class GetSumCreditDebit {
    private static Connection connection;
    public static void getConnection() throws SQLException, ClassNotFoundException {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        connection = connectDatabase.CreateConnection();
    }
    public static void GetSumCreditDebit(int id, Timestamp startDate,Timestamp EndDate) throws SQLException, ClassNotFoundException {
        getConnection();
        String sql = "SELECT \n"+
                " COALESCE(SUM(CASE WHEN type_de_transactions = 'CREDIT' THEN montant ELSE 0 END),0) AS totalCredit,\n"+
                " COALESCE(SUM(CASE WHEN type_de_transactions = 'DEBIT' THEN montant ELSE 0 END),0) AS totalDebit\n"+
                " FROM transactions WHERE id_compte=? AND date_de_transactions BETWEEN ? AND ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1,id);
            statement.setTimestamp(2,startDate);
            statement.setTimestamp(3,EndDate);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Double solde = resultSet.getDouble("totalCredit");
                Double solde2 = resultSet.getDouble("totalDebit");
                Double montantNet = solde-solde2;
                System.out.println("credit: "+solde+ "  debit:"+solde2+ "MontantNet: "+montantNet);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        }
}
