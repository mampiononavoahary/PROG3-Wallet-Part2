package com.example.Walletpart2.Walletpart2.Service.GetAccountDebitCredit;

import com.example.Walletpart2.Walletpart2.Database.ConnectDatabase;

import java.sql.*;

public class GetSumAccountCredit {
    private static Connection connection;
    public static void getConnection() throws SQLException, ClassNotFoundException {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        connection = connectDatabase.CreateConnection();
    }
    public static void getSumAccountCredit(int id, Timestamp dateStart, Timestamp dateEnd) throws SQLException, ClassNotFoundException {
        String sql = "SELECT sum(transactions.montant)as credit FROM transactions INNER JOIN compte ON transactions.id_compte= compte.id WHERE compte.id=? AND transactions.type_de_transactions='CREDIT' AND date_de_transactions BETWEEN ? AND ? GROUP BY transactions.type_de_transactions;\n;";
        getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            statement.setTimestamp(2,dateStart);
            statement.setTimestamp(3,dateEnd);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Double amount = resultSet.getDouble("credit");

                System.out.println("Sum of credit between two date : \n" +" -credit :"+ amount);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
