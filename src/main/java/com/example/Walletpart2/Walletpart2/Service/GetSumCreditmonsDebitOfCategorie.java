package com.example.Walletpart2.Walletpart2.Service;

import com.example.Walletpart2.Walletpart2.Database.ConnectDatabase;

import java.sql.*;

public class GetSumCreditmonsDebitOfCategorie {
    private static Connection connection;
    public static void getConnection() throws SQLException, ClassNotFoundException {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        connection = connectDatabase.CreateConnection();
    }
    public static void GetSumCreditmonsDebitOfCategorie(int id, Timestamp StartDate,Timestamp EndDate) throws SQLException, ClassNotFoundException {
        getConnection();

        String sql = "SELECT \n"+
                " COALESCE(SUM(CASE WHEN c.name = 'Restaurant' THEN t.montant ELSE 0 END),0) AS restaurant,\n"+
                " COALESCE(SUM(CASE WHEN c.name = 'Salaire' THEN t.montant ELSE 0 END),0) AS salaire\n"+
                " FROM transactions t INNER JOIN categorie c ON t.id_categorie = c.id WHERE id_compte=? AND date_de_transactions BETWEEN ? AND ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1,id);
            statement.setTimestamp(2,StartDate);
            statement.setTimestamp(3,EndDate);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Double restaurant = resultSet.getDouble("restaurant");
                Double Salaire = resultSet.getDouble("salaire");

                System.out.println("Restaurant: "+restaurant+" Salaire: "+Salaire);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
