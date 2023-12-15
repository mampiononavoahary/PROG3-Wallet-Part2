package com.example.Walletpart2.Walletpart2.Service.GetAccountDebitCredit;

import com.example.Walletpart2.Walletpart2.Database.ConnectDatabase;

import java.sql.*;

public class GetSumAccountDebit {
    private static Connection connection;

    public static void getConnection() throws SQLException, ClassNotFoundException {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        connection = connectDatabase.CreateConnection();
    }
    public static void GetSumAccountDebit(int id, Timestamp dateStart, Timestamp dateEnd) throws SQLException, ClassNotFoundException {
        String sql = "SELECT sum(transactions.montant)as debit FROM transactions INNER JOIN compte ON transactions.id_compte= compte.id WHERE compte.id=? AND transactions.type_de_transactions='DEBIT' AND date_de_transactions BETWEEN ?AND ? GROUP BY type_de_transactions;";

      getConnection();

      try {
          PreparedStatement statement= connection.prepareStatement(sql);
          statement.setInt(1,id);
          statement.setTimestamp(2,dateStart);
          statement.setTimestamp(3,dateEnd);

          ResultSet resultSet = statement.executeQuery();

          while (resultSet.next()){
              Double solde = resultSet.getDouble("debit");
              System.out.println("This is the sum of debit between two date :\n  -debit: " +solde);
          }
      }catch (Exception e){
          e.printStackTrace();
      }
    }
}
