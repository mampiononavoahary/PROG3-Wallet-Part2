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
public class comptes {
    private int id;
    private String nom_de_compte;
    private double solde;
    private LocalDateTime solde_date_mis_a_jour;
    private int id_devise;
    private typeCompte type;
}
