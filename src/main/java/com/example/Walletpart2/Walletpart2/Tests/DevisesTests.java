package com.example.Walletpart2.Walletpart2.Tests;

import com.example.Walletpart2.Walletpart2.Model.CodeDevises;
import com.example.Walletpart2.Walletpart2.Model.NomDevises;
import com.example.Walletpart2.Walletpart2.Model.devises;
import com.example.Walletpart2.Walletpart2.Repository.devisesCrudOperations;

import java.sql.SQLException;

public class DevisesTests {
    public static void DevisesTest() throws SQLException, ClassNotFoundException {
        devisesCrudOperations devisesCrudOperations = new devisesCrudOperations();

        devises devises = new devises(2, NomDevises.EURO, CodeDevises.EUR);
//        devisesCrudOperations.save(devises);
        devisesCrudOperations.findAll();
    }
}
