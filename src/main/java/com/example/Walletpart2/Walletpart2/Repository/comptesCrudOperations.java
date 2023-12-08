package com.example.Walletpart2.Walletpart2.Repository;

import com.example.Walletpart2.Walletpart2.Database.ConnectDatabase;
import com.example.Walletpart2.Walletpart2.Model.comptes;
import com.example.Walletpart2.Walletpart2.Model.typeCompte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class comptesCrudOperations implements CrudOperations<comptes>{
    private static Connection connection;
    public static void getConnection() throws SQLException, ClassNotFoundException {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        connection = connectDatabase.CreateConnection();
    }
    private comptes extractResultset(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String nomCompte = resultSet.getString("nom_de_compte");
        double solde = resultSet.getDouble("solde");
        LocalDateTime dateMisAJour = resultSet.getTimestamp("solde_date_mis_a_jour").toLocalDateTime();
        int idDevise = resultSet.getInt("id_devise");
        typeCompte type = typeCompte.valueOf(resultSet.getString("type"));

        return new comptes(id,nomCompte,solde,dateMisAJour,idDevise,type);
    }
    @Override
    public List<comptes> findAll() throws SQLException, ClassNotFoundException {
        List<comptes> comptes = new ArrayList<>() ;
        String sql = "SELECT * FROM compte" ;
        getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet =preparedStatement.executeQuery()){
            while (resultSet.next()){
                comptes compte= extractResultset(resultSet);
                comptes.add(compte);
                System.out.println(compte);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return comptes;
    }

    @Override
    public List<comptes> saveAll(List<comptes> toSave) {
        List<comptes> arrayComptes = new ArrayList<>();
        try {
            String sql = "INSERT INTO Comptes(id,nomCompte,solde,dateMisAJour,idDevise,type) VALUES(?,?,?,?,?,?);";
            getConnection();
            try (PreparedStatement statement = connection.prepareStatement(sql)){
               for (comptes compte: toSave){
                   statement.setInt(1,compte.getId());
                   statement.setString(2,compte.getNom_de_compte());
                   statement.setDouble(3,compte.getSolde());
                   statement.setObject(4,compte.getSolde_date_mis_a_jour());
                   statement.setInt(5,compte.getId_devise());
                   statement.setObject(6,compte.getType());

                   int rows = statement.executeUpdate();

                   if (rows>0){
                       arrayComptes.add(compte);
                   }
               }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
       return arrayComptes;
    }

    @Override
    public comptes save(comptes toSave) {
        try {
            String sql = "INSERT INTO Comptes(id,nomCompte,solde,dateMisAJour,idDevise,type) VALUES(?,?,?,?,?,?);";

            getConnection();
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1,toSave.getId());
                statement.setString(2,toSave.getNom_de_compte());
                statement.setDouble(3,toSave.getSolde());
                statement.setObject(4,toSave.getSolde_date_mis_a_jour());
                statement.setInt(5,toSave.getId_devise());
                statement.setObject(6,toSave.getType());

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
    public comptes update(comptes toUpdate) {
        try {
            String sql = "UPDATE compte SET nomCompte=?,solde=?,dateMisAJour=?,idDevise=?,type=? WHERE id=?;";

            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1,toUpdate.getNom_de_compte());
                statement.setDouble(2,toUpdate.getSolde());
                statement.setObject(3,toUpdate.getSolde_date_mis_a_jour());
                statement.setInt(4,toUpdate.getId_devise());
                statement.setObject(5,toUpdate.getType());
                statement.setInt(6,toUpdate.getId());

                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }catch (Exception e){
            e.fillInStackTrace();
        }
        return null;
    }
}
