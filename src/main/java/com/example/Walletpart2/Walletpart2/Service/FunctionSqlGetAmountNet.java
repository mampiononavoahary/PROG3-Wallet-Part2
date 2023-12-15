package com.example.Walletpart2.Walletpart2.Service;

import com.example.Walletpart2.Walletpart2.Database.ConnectDatabase;

import java.sql.*;

public class FunctionSqlGetAmountNet {
    private static Connection connection;
    public static void getConnection() throws SQLException, ClassNotFoundException {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        connection = connectDatabase.CreateConnection();
    }
    public static void getAmountNet(int id, Timestamp dateStart, Timestamp dateEnd) throws SQLException, ClassNotFoundException {
        String sql = "SELECT get_money_transactions_sum(?,?,?) AS total_amount;";
        getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            statement.setTimestamp(2,dateStart);
            statement.setTimestamp(3,dateEnd);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Double solde = resultSet.getDouble("total_amount");

                System.out.println("This is the sum of amount net: \n" +solde);
            }

        }catch (Exception e){
            e.fillInStackTrace();
        }
    }
}
