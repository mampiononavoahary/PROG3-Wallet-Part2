package com.example.Walletpart2.Walletpart2.Repository;

import com.example.Walletpart2.Walletpart2.Database.ConnectDatabase;
import com.example.Walletpart2.Walletpart2.Model.comptes;
import com.example.Walletpart2.Walletpart2.Model.transactions;
import com.example.Walletpart2.Walletpart2.Model.typeTransactions;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class transactionsCrudOperations implements CrudOperations<transactions>{
    private static Connection connection;
    public static void getConnection() throws SQLException, ClassNotFoundException {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        connection = connectDatabase.CreateConnection();
    }
    private static transactions extractTransactions(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int id_compte = resultSet.getInt("id_compte");
        String label = resultSet.getString("label");
        Double montant = resultSet.getDouble("montant");
        LocalDateTime dateTransaction = resultSet.getTimestamp("date_de_transactions").toLocalDateTime();
        typeTransactions type = typeTransactions.valueOf(resultSet.getString("type_de_transactions"));

        return new transactions(id,id_compte,label,montant,dateTransaction,type);
    }

    @Override
    public List<transactions> findAll() throws SQLException, ClassNotFoundException {
        List<transactions> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions;";
        getConnection();
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                transactions transaction = extractTransactions(resultSet);
                transactions.add(transaction);
            }
            for (transactions transaction : transactions){
                System.out.println(transaction);
            }
        }
        return transactions;
    }

    @Override
    public List<transactions> saveAll(List<transactions> toSave) {
        List<transactions> transactions = new ArrayList<>();
        try {
            String sql = "INSERT INTO transactions(id,id_compte,label,montant,date_de_transacitons,type_de_transactions)VALUES(?,?,?,?,?,?);";
            getConnection();
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                for (transactions transaction : toSave){
                    statement.setInt(1,transaction.getId());
                    statement.setInt(2,transaction.getId_compte());
                    statement.setString(3,transaction.getLabel());
                    statement.setDouble(4,transaction.getMontant());
                    statement.setObject(5,transaction.getDate_de_transactions());
                    statement.setObject(6,transaction.getType(), Types.OTHER);

                    int rows = statement.executeUpdate();
                    while (rows>0){
                        transactions.add(transaction);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return transactions;
    }

    @Override
    public transactions save(transactions toSave) {
        try {
            String sql =" INSERT INTO transactions(id,id_compte,label,montant,date_de_transactions,type_de_transactions)VALUES(?,?,?,?,?,?); ";
            getConnection();
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1,toSave.getId());
                statement.setInt(2,toSave.getId_compte());
                statement.setString(3,toSave.getLabel());
                statement.setDouble(4,toSave.getMontant());
                statement.setObject(5,toSave.getDate_de_transactions());
                statement.setObject(6,toSave.getType(),Types.OTHER);

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
    public transactions update(transactions toUpdate) {
        try {
            String sql =" UPDATE transactions SET id_compte=?,label=?,montant=?,date_de_transactions=?,type_de_transactions=? WHERE id=?;";
            getConnection();
            try (PreparedStatement statement = connection.prepareStatement(sql)){

                statement.setInt(1,toUpdate.getId_compte());
                statement.setString(2,toUpdate.getLabel());
                statement.setDouble(3,toUpdate.getMontant());
                statement.setObject(4,toUpdate.getDate_de_transactions());
                statement.setObject(5,toUpdate.getType(),Types.OTHER);
                statement.setInt(6,toUpdate.getId());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void CangeCompteAfterTransactions(comptes comptes, transactions transactions) throws SQLException, ClassNotFoundException {
        getConnection();
        switch (transactions.getType()){
            case CREDIT  :
                BigDecimal soldeBigDecimal = BigDecimal.valueOf(comptes.getSolde());
                BigDecimal montantBigDecimal = BigDecimal.valueOf(transactions.getMontant());
                BigDecimal updatedSoldeBigDecimal = soldeBigDecimal.add(montantBigDecimal);
                Double updatedSoldeDouble = updatedSoldeBigDecimal.doubleValue();
                try{
                    String sql = "INSERT INTO Transaction (id,id_compte, label,montant ,date_de_transactions,type_de_transactions) " +
                            "VALUES (?, ?, ?, ?, ?,?) " +
                            "ON CONFLICT (id) " +
                            "DO UPDATE SET amount = EXCLUDED.montant, label = EXCLUDED.label, " +
                            "type_de_transactions = EXCLUDED.type_de_transactions, date_de_transactions = EXCLUDED.date_de_transactions , id_compte = EXCLUDED.id_compte";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql) ;
                    preparedStatement.setInt(1 , transactions.getId());
                    preparedStatement.setInt(2 , transactions.getId_compte());
                    preparedStatement.setString(3 , transactions.getLabel());
                    preparedStatement.setDouble(4 , transactions.getMontant());
                    preparedStatement.setObject(5 , transactions.getDate_de_transactions());
                    preparedStatement.setObject(6 ,transactions.getType(), Types.OTHER);
                    preparedStatement.executeUpdate();
                    String update = "UPDATE compte SET solde = ? WHERE id = ?" ;
                    PreparedStatement ps = connection.prepareStatement(update) ;
                    ps.setDouble(1  , updatedSoldeDouble);
                    ps.setInt(2 ,comptes.getId());
                    ps.executeUpdate() ;

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case DEBIT :
                BigDecimal solde1 = BigDecimal.valueOf(comptes.getSolde());
                BigDecimal montant2 = BigDecimal.valueOf(transactions.getMontant());

                BigDecimal updatedSolde = solde1.add(montant2);
                Double updatedSolde2 = updatedSolde.doubleValue();
                try {
                    String sql = "INSERT INTO Transaction (id, label, amount ,date,type, id_account) " +
                            "VALUES (?, ?, ?, ?, ?,?) " +
                            "ON CONFLICT (id) " +
                            "DO UPDATE SET amount = EXCLUDED.amount, label = EXCLUDED.label, " +
                            "type = EXCLUDED.type, date = EXCLUDED.date , id_account = EXCLUDED.id_account";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql) ;
                    preparedStatement.setInt(1 , transactions.getId());
                    preparedStatement.setInt(2 , transactions.getId_compte());
                    preparedStatement.setString(3 , transactions.getLabel());
                    preparedStatement.setDouble(4 , transactions.getMontant());
                    preparedStatement.setObject(5 , transactions.getDate_de_transactions());
                    preparedStatement.setObject(6 ,transactions.getType(), Types.OTHER);
                    preparedStatement.executeUpdate();
                    String update = "UPDATE compte SET solde = ? WHERE id = ?" ;
                    PreparedStatement ps = connection.prepareStatement(update) ;
                    ps.setDouble(1  , updatedSolde2);
                    ps.setInt(2 ,comptes.getId());
                    ps.executeUpdate() ;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

        }
        }
    }
