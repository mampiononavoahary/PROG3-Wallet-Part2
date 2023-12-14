package com.example.Walletpart2.Walletpart2.Tests;

import com.example.Walletpart2.Walletpart2.Model.comptes;
import com.example.Walletpart2.Walletpart2.Model.transactions;
import com.example.Walletpart2.Walletpart2.Model.typeTransactions;
import com.example.Walletpart2.Walletpart2.Repository.transactionsCrudOperations;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class TransactionTests {
        public static void transactionTest() throws SQLException, ClassNotFoundException {
            compteTests compteTests;
            LocalDateTime updatedDate = LocalDateTime.now();


            Double value = 20000.00;
            transactions transaction = new transactions(1,1,"cadeaux de Noel", value,updatedDate,typeTransactions.CREDIT);
            transactionsCrudOperations test = new transactionsCrudOperations();

            //test.CangeCompteAfterTransactions();
            test.save(transaction);
            test.findAll();
        }
}
