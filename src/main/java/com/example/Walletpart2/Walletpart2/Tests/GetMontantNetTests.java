package com.example.Walletpart2.Walletpart2.Tests;

import com.example.Walletpart2.Walletpart2.Service.GetSumCreditDebit;

import java.sql.SQLException;
import java.sql.Timestamp;

public class GetMontantNetTests {
    public static void GetMontantNetTests() throws SQLException, ClassNotFoundException {
     GetSumCreditDebit getSumCreditDebit = new GetSumCreditDebit();
        Timestamp dateDebut = Timestamp.valueOf("2023-10-10 23:53:27.778397");
        Timestamp dateEnd = Timestamp.valueOf("2023-12-30 23:53:27.778397");
        GetSumCreditDebit.GetSumCreditDebit(1,dateDebut,dateEnd);

    }

}
