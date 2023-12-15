package com.example.Walletpart2.Walletpart2.Tests;

import com.example.Walletpart2.Walletpart2.Model.comptes;
import com.example.Walletpart2.Walletpart2.Model.transactions;
import com.example.Walletpart2.Walletpart2.Model.typeCompte;
import com.example.Walletpart2.Walletpart2.Model.typeTransactions;
import com.example.Walletpart2.Walletpart2.Repository.comptesCrudOperations;
import com.example.Walletpart2.Walletpart2.Repository.transactionsCrudOperations;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class TransactionTests {
        public static void transactionTest() throws SQLException, ClassNotFoundException {
            comptesCrudOperations comptesCrudOperations = new comptesCrudOperations();
            comptes compte = new comptes(1,"compte courant",2000.0, LocalDateTime.now(),1, typeCompte.BANK);
            compteTests compteTests;
            LocalDateTime updatedDate = LocalDateTime.now();


            Double value = 500.00;
            transactions transaction = new transactions(1,1,"cadeaux de Noel", value,updatedDate,typeTransactions.DEBIT,1);


            Double debiter = 20000.00;
            transactions transaction2 = new transactions(2,1,"Tax", debiter,updatedDate,typeTransactions.CREDIT,2);
            transactionsCrudOperations test = new transactionsCrudOperations();

            test.CangeCompteAfterTransactions(compte,transaction);
            test.CangeCompteAfterTransactions(compte,transaction2);
            //test.save(transaction);
            test.findAll();
        }
}
