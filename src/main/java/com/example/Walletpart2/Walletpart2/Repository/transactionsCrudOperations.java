package com.example.Walletpart2.Walletpart2.Repository;

import com.example.Walletpart2.Walletpart2.Database.ConnectDatabase;
import com.example.Walletpart2.Walletpart2.Model.comptes;
import com.example.Walletpart2.Walletpart2.Model.transactions;
import com.example.Walletpart2.Walletpart2.Model.typeTransactions;
import com.example.Walletpart2.Walletpart2.Service.TransfertSolde;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class transactionsCrudOperations implements CrudOperations<transactions> {
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
        int id_categorie = resultSet.getInt("id_categorie");

        return new transactions(id, id_compte, label, montant, dateTransaction, type, id_categorie);
    }

    @Override
    public List<transactions> findAll() throws SQLException, ClassNotFoundException {
        List<transactions> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions;";
        getConnection();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                transactions transaction = extractTransactions(resultSet);
                transactions.add(transaction);
            }
            for (transactions transaction : transactions) {
                System.out.println(transaction);
            }
        }
        return transactions;
    }

    @Override
    public List<transactions> saveAll(List<transactions> toSave) {
        List<transactions> transactions = new ArrayList<>();
        try {
            String sql = "INSERT INTO transactions(id,id_compte,label,montant,date_de_transacitons,type_de_transactions,id_categorie)VALUES(?,?,?,?,?,?,?) on conflict do nothing;";
            getConnection();
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                for (transactions transaction : toSave) {
                    statement.setInt(1, transaction.getId());
                    statement.setInt(2, transaction.getId_compte());
                    statement.setString(3, transaction.getLabel());
                    statement.setDouble(4, transaction.getMontant());
                    statement.setObject(5, transaction.getDate_de_transactions());
                    statement.setObject(6, transaction.getType(), Types.OTHER);
                    statement.setInt(7, transaction.getId_categorie());

                    int rows = statement.executeUpdate();
                    while (rows > 0) {
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
            String sql = " INSERT INTO transactions(id,id_compte,label,montant,date_de_transactions,type_de_transactions,id_categorie)VALUES(?,?,?,?,?,?,?) ON conflict do nothing; ";
            getConnection();
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, toSave.getId());
                statement.setInt(2, toSave.getId_compte());
                statement.setString(3, toSave.getLabel());
                statement.setDouble(4, toSave.getMontant());
                statement.setObject(5, toSave.getDate_de_transactions());
                statement.setObject(6, toSave.getType(), Types.OTHER);
                statement.setInt(7, toSave.getId_categorie());
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
            String sql = " UPDATE transactions SET id_compte=?,label=?,montant=?,date_de_transactions=?,type_de_transactions=?,id_categorie=? WHERE id=?;";
            getConnection();
            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setInt(1, toUpdate.getId_compte());
                statement.setString(2, toUpdate.getLabel());
                statement.setDouble(3, toUpdate.getMontant());
                statement.setObject(4, toUpdate.getDate_de_transactions());
                statement.setObject(5, toUpdate.getType(), Types.OTHER);
                statement.setInt(6, toUpdate.getId_categorie());
                statement.setInt(7, toUpdate.getId());

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
        String typeCategories = GetCategorie.CategorieList(transactions.getId_categorie());
        switch (transactions.getType()) {
            case CREDIT:
                if (typeCategories.equals("incomes")) {
                    Double soldeBigDecimal = comptes.getSolde();
                    Double montantBigDecimal = transactions.getMontant();
                    Double updatedSoldeBigDecimal = soldeBigDecimal + montantBigDecimal;

                    try {
                        String sql = "INSERT INTO transactions (id,id_compte, label,montant ,date_de_transactions,type_de_transactions,id_categorie) " +
                                "VALUES (?, ?, ?, ?, ?,?,?) " +
                                "ON CONFLICT (id) " +
                                "DO UPDATE SET id_compte = EXCLUDED.id_compte, label = EXCLUDED.label, montant = EXCLUDED.montant, " +
                                " date_de_transactions = EXCLUDED.date_de_transactions,type_de_transactions = EXCLUDED.type_de_transactions,id_categorie= EXCLUDED.id_categorie; ";
                        PreparedStatement preparedStatement = connection.prepareStatement(sql);
                        preparedStatement.setInt(1, transactions.getId());
                        preparedStatement.setInt(2, transactions.getId_compte());
                        preparedStatement.setString(3, transactions.getLabel());
                        preparedStatement.setDouble(4, transactions.getMontant());
                        preparedStatement.setObject(5, transactions.getDate_de_transactions());
                        preparedStatement.setObject(6, transactions.getType(), Types.OTHER);
                        preparedStatement.setInt(7, transactions.getId_categorie());
                        preparedStatement.executeUpdate();
                        String update = "UPDATE compte SET solde = ? WHERE id = ?";
                        PreparedStatement ps = connection.prepareStatement(update);
                        ps.setDouble(1, updatedSoldeBigDecimal);
                        ps.setInt(2, comptes.getId());
                        ps.executeUpdate();

                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                } else {
                    System.out.println("Transactions error : incompatibles of CREDIT and categories types");
                }

            case DEBIT:
                if (typeCategories.equals("expenses")) {
                    Double solde1 = comptes.getSolde();
                    Double montant2 = transactions.getMontant();

                    Double updatedSolde = solde1 - montant2;

                    try {
                        String sql = "INSERT INTO transactions (id,id_compte, label,montant ,date_de_transactions,type_de_transactions,id_categorie) " +
                                "VALUES (?, ?, ?, ?, ?,?,?) " +
                                "ON CONFLICT (id) " +
                                "DO UPDATE SET id_compte = EXCLUDED.id_compte, label = EXCLUDED.label, montant = EXCLUDED.montant, " +
                                " date_de_transactions = EXCLUDED.date_de_transactions,type_de_transactions = EXCLUDED.type_de_transactions,id_categorie= EXCLUDED.id_categorie ";
                        PreparedStatement preparedStatement = connection.prepareStatement(sql);
                        preparedStatement.setInt(1, transactions.getId());
                        preparedStatement.setInt(2, transactions.getId_compte());
                        preparedStatement.setString(3, transactions.getLabel());
                        preparedStatement.setDouble(4, transactions.getMontant());
                        preparedStatement.setObject(5, transactions.getDate_de_transactions());
                        preparedStatement.setObject(6, transactions.getType(), Types.OTHER);
                        preparedStatement.setInt(7, transactions.getId_categorie());
                        preparedStatement.executeUpdate();
                        String update = "UPDATE compte SET solde = ? WHERE id = ?";
                        PreparedStatement preparedStatement1 = connection.prepareStatement(update);
                        preparedStatement1.setDouble(1, updatedSolde);
                        preparedStatement1.setInt(2, comptes.getId());
                        preparedStatement1.executeUpdate();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                } else {
                    System.out.println("Transactions error: incompatible of DEBIT and Categories type");
                }
        }
    }
}
