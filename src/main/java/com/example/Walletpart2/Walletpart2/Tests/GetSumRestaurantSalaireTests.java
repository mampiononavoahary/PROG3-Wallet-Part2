package com.example.Walletpart2.Walletpart2.Tests;

import com.example.Walletpart2.Walletpart2.Service.GetSumCreditmonsDebitOfCategorie;

import java.sql.SQLException;
import java.sql.Timestamp;

public class GetSumRestaurantSalaireTests {
    public static void GetSumRestaurantSalaireTests() throws SQLException, ClassNotFoundException {
        GetSumCreditmonsDebitOfCategorie getSumCreditmonsDebitOfCategorie = new GetSumCreditmonsDebitOfCategorie();

        Timestamp dateDebut = Timestamp.valueOf("2023-10-10 23:53:27.778397");
        Timestamp dateEnd = Timestamp.valueOf("2023-12-30 23:53:27.778397");

        GetSumCreditmonsDebitOfCategorie.GetSumCreditmonsDebitOfCategorie(1,dateDebut,dateEnd);
    }
}
