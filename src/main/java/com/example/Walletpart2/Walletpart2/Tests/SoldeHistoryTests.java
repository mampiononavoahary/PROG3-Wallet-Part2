package com.example.Walletpart2.Walletpart2.Tests;

import com.example.Walletpart2.Walletpart2.Repository.SoldeHistoriqueCrudOperations;

import java.sql.SQLException;
import java.sql.Timestamp;

public class SoldeHistoryTests {
    public static void SoldeHitoryTests() throws SQLException, ClassNotFoundException {
        SoldeHistoriqueCrudOperations soldeHistoriqueCrudOperations = new SoldeHistoriqueCrudOperations();

        soldeHistoriqueCrudOperations.listSoldeWithDate(1);

        Timestamp dateDebut = Timestamp.valueOf("2023-10-10 23:53:27.778397");
        Timestamp dateEnd = Timestamp.valueOf("2023-12-30 23:53:27.778397");
        soldeHistoriqueCrudOperations.historyOfBalanceOfAccount(1,dateDebut,dateEnd);
    }
}
