package com.example.Walletpart2.Walletpart2.Repository;

import com.example.Walletpart2.Walletpart2.Database.ConnectDatabase;
import com.example.Walletpart2.Walletpart2.Model.CodeDevises;
import com.example.Walletpart2.Walletpart2.Model.NomDevises;
import com.example.Walletpart2.Walletpart2.Model.devises;

import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class devisesCrudOperations implements CrudOperations<devises>{
    private static Connection connection;
    public static void getConnection() throws SQLException, ClassNotFoundException {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        connection = connectDatabase.CreateConnection();
    }
    public static devises extractDevise(ResultSet resultSet) throws SQLException {
       int id = resultSet.getInt("devise_id");
        NomDevises nomDevises = NomDevises.valueOf(resultSet.getString("nom"));
        CodeDevises codeDevises = CodeDevises.valueOf(resultSet.getString("code"));

        return new devises(id,nomDevises,codeDevises);
    }
    @Override
    public List<devises> findAll() throws SQLException, ClassNotFoundException {
        List<devises> devises =new ArrayList<>();
        String sql = "SELECT *FROM devises;";
        getConnection();
        try (PreparedStatement statement = connection.prepareStatement(sql)){
           ResultSet resultSet = statement.executeQuery();
           while (resultSet.next()) {
                 devises devise = extractDevise(resultSet);
                 devises.add(devise);
           }
            for (devises devise: devises){
                System.out.println(devise);
            }
        }
        return devises;
    }

    @Override
    public List<devises> saveAll(List<devises> toSave) {
        List<devises> devises = new ArrayList<>();
        try {
            String sql = "INSERT INTO devises(devise_id,nom,code)VALUES(?,?,?);";
            getConnection();
            try (PreparedStatement statement  = connection.prepareStatement(sql)){
                for (devises devise: toSave){
                    statement.setInt(1,devise.getId_devise());
                    statement.setObject(2,devise.getNomDevises(), Types.OTHER);
                    statement.setObject(3,devise.getCodeDevises(), Types.OTHER);

                    int rows = statement.executeUpdate();
                    while (rows>0){
                        devises.add(devise);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return devises;
    }

    @Override
    public devises save(devises toSave) {
        try {
            String sql ="INSERT INTO devises(devise_id,nom,code)VALUES(?,?,?);";

            getConnection();
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1,toSave.getId_devise());
                statement.setObject(2,toSave.getNomDevises(),Types.OTHER);
                statement.setObject(3,toSave.getCodeDevises(),Types.OTHER);

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public devises update(devises toUpdate) {
       try {
           String sql = "UPDATE devises SET nom=?,code=? WHERE devise_id=?;";
           getConnection();
           try (PreparedStatement statement = connection.prepareStatement(sql)){
               statement.setObject(1,toUpdate.getNomDevises(),Types.OTHER);
               statement.setObject(2,toUpdate.getCodeDevises(),Types.OTHER);
               statement.setInt(3,toUpdate.getId_devise());

               statement.executeUpdate();
           }
       } catch (SQLException e) {
           throw new RuntimeException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
       return null;

    }
}
