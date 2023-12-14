package com.example.Walletpart2.Walletpart2.Model;

import java.time.LocalDateTime;
import java.util.Date;

public class TransferHistory {
    private int id;
    private int id_compte_crediteur;
    private int id_compte_debiteur;
    private Double valeur;
    private LocalDateTime date_de_transfert;

    public TransferHistory(int id, int id_compte_crediteur, int id_compte_debiteur, Double valeur, LocalDateTime date_de_transfert) {
        this.id = id;
        this.id_compte_crediteur = id_compte_crediteur;
        this.id_compte_debiteur = id_compte_debiteur;
        this.valeur = valeur;
        this.date_de_transfert = date_de_transfert;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_compte_crediteur() {
        return id_compte_crediteur;
    }

    public void setId_compte_crediteur(int id_compte_crediteur) {
        this.id_compte_crediteur = id_compte_crediteur;
    }

    public int getId_compte_debiteur() {
        return id_compte_debiteur;
    }

    public void setId_compte_debiteur(int id_compte_debiteur) {
        this.id_compte_debiteur = id_compte_debiteur;
    }

    public Double getValeur() {
        return valeur;
    }

    public void setValeur(Double valeur) {
        this.valeur = valeur;
    }

    public LocalDateTime getDate_de_transfert() {
        return date_de_transfert;
    }

    public void setDate_de_transfert(LocalDateTime date_de_transfert) {
        this.date_de_transfert = date_de_transfert;
    }

    @Override
    public String toString() {
        return "TransferHistory{" +
                "id=" + id +
                ", id_compte_crediteur=" + id_compte_crediteur +
                ", id_compte_debiteur=" + id_compte_debiteur +
                ", valeur=" + valeur +
                ", date_de_transfert=" + date_de_transfert +
                '}';
    }
}
