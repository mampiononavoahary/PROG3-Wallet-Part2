package com.example.Walletpart2.Walletpart2.Tests;

import com.example.Walletpart2.Walletpart2.Model.transactions;
import com.example.Walletpart2.Walletpart2.Model.typeTransactions;
import com.example.Walletpart2.Walletpart2.Repository.transactionsCrudOperations;
import java.time.LocalDateTime;


public class TransactionTests {
        public static void transactionTest(){
            LocalDateTime updatedDate = LocalDateTime.now();
            Double value = 20000.00;
            transactions transaction = new transactions(1,1,"cadeaux de Noel", value,updatedDate,typeTransactions.CREDIT);
            transactionsCrudOperations test = new transactionsCrudOperations();
            test.save(transaction);
        }
}
