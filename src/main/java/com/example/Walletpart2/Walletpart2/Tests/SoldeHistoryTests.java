package com.example.Walletpart2.Walletpart2.Tests;

import com.example.Walletpart2.Walletpart2.Repository.SoldeHistoriqueCrudOperations;

import java.sql.SQLException;

public class SoldeHistoryTests {
    public static void SoldeHitoryTests() throws SQLException, ClassNotFoundException {
        SoldeHistoriqueCrudOperations soldeHistoriqueCrudOperations = new SoldeHistoriqueCrudOperations();

        soldeHistoriqueCrudOperations.listSoldeWithDate(1);
    }
}
