package com.example.Walletpart2.Walletpart2.Tests;

import com.example.Walletpart2.Walletpart2.Model.comptes;
import com.example.Walletpart2.Walletpart2.Model.typeCompte;
import com.example.Walletpart2.Walletpart2.Repository.comptesCrudOperations;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class compteTests {
    public static void  compteTets() throws SQLException, ClassNotFoundException {
        comptesCrudOperations comptesCrudOperations = new comptesCrudOperations();
        Timestamp date = Timestamp.valueOf("2023-12-13 23:53:27.778397");
        Timestamp date2 = Timestamp.valueOf("2023-11-21 21:10:12.758397");
         comptes compte = new comptes(1,"compte courant",2000.0, LocalDateTime.now(),1, typeCompte.BANK);
        comptes compte2 = new comptes(2,"compte courant",10000.0, date.toLocalDateTime(),2, typeCompte.BANK);
        comptes compte3 = new comptes(3,"compte epargne",35000.0,date2.toLocalDateTime(),2,typeCompte.MOBILE_MONEY);


        List<comptes> comptes = new ArrayList<>();
        comptes.add(compte);
        comptes.add(compte2);
        comptes.add(compte3);
        List<comptes> savedall = comptesCrudOperations.saveAll(comptes);
        System.out.println("List of comptes");
        for (comptes save : savedall){
            System.out.println(save);
        }

        comptesCrudOperations.findAll();

        compte.setSolde(200000.00);
        comptesCrudOperations.update(compte);
        System.out.println("Comptes "+compte+" updated");



        comptesCrudOperations.findSoldeByDate(date.toLocalDateTime());
    }
}
