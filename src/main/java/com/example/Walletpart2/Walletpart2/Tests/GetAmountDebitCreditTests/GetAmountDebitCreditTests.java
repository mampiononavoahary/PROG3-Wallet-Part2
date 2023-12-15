package com.example.Walletpart2.Walletpart2.Tests.GetAmountDebitCreditTests;

import com.example.Walletpart2.Walletpart2.Service.GetAccountDebitCredit.GetSumAccountCredit;
import com.example.Walletpart2.Walletpart2.Service.GetAccountDebitCredit.GetSumAccountDebit;
import com.example.Walletpart2.Walletpart2.Service.GetSumCreditDebit;

import java.sql.SQLException;
import java.sql.Timestamp;

public class GetAmountDebitCreditTests {
    public static void GetAmountDebitCreditTests() throws SQLException, ClassNotFoundException {
        GetSumAccountDebit getSumAccountDebit = new GetSumAccountDebit();
        GetSumAccountCredit getSumAccountCredit = new GetSumAccountCredit();
        Timestamp dateDebut = Timestamp.valueOf("2023-10-10 23:53:27.778397");
        Timestamp dateEnd = Timestamp.valueOf("2023-12-30 23:53:27.778397");

        GetSumAccountCredit.getSumAccountCredit(1,dateDebut,dateEnd);
        GetSumAccountDebit.GetSumAccountDebit(1,dateDebut,dateEnd);
    }
}
