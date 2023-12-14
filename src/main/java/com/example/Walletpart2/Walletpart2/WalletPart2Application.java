package com.example.Walletpart2.Walletpart2;

import com.example.Walletpart2.Walletpart2.Tests.DevisesTests;
import com.example.Walletpart2.Walletpart2.Tests.SoldeHistoryTests;
import com.example.Walletpart2.Walletpart2.Tests.TransactionTests;
import com.example.Walletpart2.Walletpart2.Tests.compteTests;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class WalletPart2Application {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//		TransactionTests.transactionTest();
//		DevisesTests.DevisesTest();
//        compteTests.compteTets();
		SoldeHistoryTests.SoldeHitoryTests();
	}

}
