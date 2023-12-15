package com.example.Walletpart2.Walletpart2;

import com.example.Walletpart2.Walletpart2.Service.FunctionSqlGetAmountNet;
import com.example.Walletpart2.Walletpart2.Service.GetSumCreditmonsDebitOfCategorie;
import com.example.Walletpart2.Walletpart2.Tests.*;
import com.example.Walletpart2.Walletpart2.Tests.GetAmountDebitCreditTests.GetAmountDebitCreditTests;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class WalletPart2Application {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		DevisesTests devisesTests = new DevisesTests();
		TransactionTests transactionTests = new TransactionTests();
		TransactionTests.transactionTest();
		DevisesTests.DevisesTest();
		compteTests.compteTets();
		SoldeHistoryTests.SoldeHitoryTests();
		GetMontantNetTests.GetMontantNetTests();
		GetSumRestaurantSalaireTests.GetSumRestaurantSalaireTests();

		FunctionSqlGetAmountNetTests.FunctionSqlGetAmountNetTests();

		GetAmountDebitCreditTests.GetAmountDebitCreditTests();
	}

}
