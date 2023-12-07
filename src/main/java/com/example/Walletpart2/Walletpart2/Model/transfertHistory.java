package com.example.Walletpart2.Walletpart2.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class transfertHistory {
    private int id;
    private int transaction_debiteur;
    private int transaction_crediteur;
    private LocalDateTime date_de_transfert;
}
