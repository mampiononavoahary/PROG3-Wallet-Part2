package com.example.Walletpart2.Walletpart2.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class transactions {
    private int id;
    private int id_compte;
    private String label;
    private double montant;
    private LocalDateTime date_de_transactions;
    private typeTransactions type;

}
