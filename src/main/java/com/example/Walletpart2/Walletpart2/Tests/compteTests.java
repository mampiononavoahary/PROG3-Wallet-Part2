package com.example.Walletpart2.Walletpart2.Tests;

import com.example.Walletpart2.Walletpart2.Repository.comptesCrudOperations;

import java.sql.SQLException;

public class compteTests {
    public static void  compteTets() throws SQLException, ClassNotFoundException {
        comptesCrudOperations comptesCrudOperations = new comptesCrudOperations();

        comptesCrudOperations.findAll();
    }
}
