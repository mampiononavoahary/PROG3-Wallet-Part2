package com.example.Walletpart2.Walletpart2.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class transfertHistory {
    private int id;
    private int transaction_debiteur;
    private int transaction_crediteur;
    private LocalDateTime date_de_transfert;

    public transfertHistory(int id, int transaction_debiteur, int transaction_crediteur, LocalDateTime date_de_transfert) {
        this.id = id;
        this.transaction_debiteur = transaction_debiteur;
        this.transaction_crediteur = transaction_crediteur;
        this.date_de_transfert = date_de_transfert;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTransaction_debiteur() {
        return transaction_debiteur;
    }

    public void setTransaction_debiteur(int transaction_debiteur) {
        this.transaction_debiteur = transaction_debiteur;
    }

    public int getTransaction_crediteur() {
        return transaction_crediteur;
    }

    public void setTransaction_crediteur(int transaction_crediteur) {
        this.transaction_crediteur = transaction_crediteur;
    }

    public LocalDateTime getDate_de_transfert() {
        return date_de_transfert;
    }

    public void setDate_de_transfert(LocalDateTime date_de_transfert) {
        this.date_de_transfert = date_de_transfert;
    }

    @Override
    public String toString() {
        return "transfertHistory{" +
                "id=" + id +
                ", transaction_debiteur=" + transaction_debiteur +
                ", transaction_crediteur=" + transaction_crediteur +
                ", date_de_transfert=" + date_de_transfert +
                '}';
    }
}
