package com.example.Walletpart2.Walletpart2.Tests;

import com.example.Walletpart2.Walletpart2.Service.FunctionSqlGetAmountNet;

import java.sql.SQLException;
import java.sql.Timestamp;

public class FunctionSqlGetAmountNetTests {
    public static void FunctionSqlGetAmountNetTests() throws SQLException, ClassNotFoundException {
        FunctionSqlGetAmountNet functionSqlGetAmountNet = new FunctionSqlGetAmountNet();

        Timestamp dateDebut = Timestamp.valueOf("2023-10-10 23:53:27.778397");
        Timestamp dateEnd = Timestamp.valueOf("2023-12-30 23:53:27.778397");

        FunctionSqlGetAmountNet.getAmountNet(1,dateDebut,dateEnd);

    }
}
