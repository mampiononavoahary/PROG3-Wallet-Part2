package com.example.Walletpart2.Walletpart2.Tests;

import com.example.Walletpart2.Walletpart2.Model.CodeDevises;
import com.example.Walletpart2.Walletpart2.Model.NomDevises;
import com.example.Walletpart2.Walletpart2.Model.devises;
import com.example.Walletpart2.Walletpart2.Repository.devisesCrudOperations;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DevisesTests {
    public static void DevisesTest() throws SQLException, ClassNotFoundException {
        devisesCrudOperations devisesCrudOperations = new devisesCrudOperations();

        devises devises = new devises(1, NomDevises.EURO, CodeDevises.EUR);
        devisesCrudOperations.save(devises);
        devisesCrudOperations.findAll();
        List<devises> devises1 = new ArrayList<>();
        devises1.add(devises);
        List<devises> savedAll = devisesCrudOperations.saveAll(devises1);
        System.out.println("List of Devises");
        for (devises devises2 : savedAll){
            System.out.println(devises2);
        }

        devises.setNomDevises(NomDevises.ARIARY);
        devisesCrudOperations.update(devises);
        System.out.println("Devise "+devises+" updated");
    }
}
