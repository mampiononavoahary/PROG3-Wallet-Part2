package com.example.Walletpart2.Walletpart2;

import com.example.Walletpart2.Walletpart2.Tests.compteTests;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class WalletPart2Application {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		compteTests compteTests = new compteTests();

		compteTests.compteTets();
	}

}
