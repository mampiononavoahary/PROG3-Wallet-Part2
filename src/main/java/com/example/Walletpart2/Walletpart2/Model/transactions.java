package com.example.Walletpart2.Walletpart2.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


public class transactions {
    private int id;
    private int id_compte;
    private String label;
    private double montant;
    private LocalDateTime date_de_transactions;
    private typeTransactions type;
    private int id_categorie;

    public transactions(int id, int id_compte, String label, double montant, LocalDateTime date_de_transactions, typeTransactions type, int id_categorie) {
        this.id = id;
        this.id_compte = id_compte;
        this.label = label;
        this.montant = montant;
        this.date_de_transactions = date_de_transactions;
        this.type = type;
        this.id_categorie = id_categorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_compte() {
        return id_compte;
    }

    public void setId_compte(int id_compte) {
        this.id_compte = id_compte;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public LocalDateTime getDate_de_transactions() {
        return date_de_transactions;
    }

    public void setDate_de_transactions(LocalDateTime date_de_transactions) {
        this.date_de_transactions = date_de_transactions;
    }

    public typeTransactions getType() {
        return type;
    }

    public void setType(typeTransactions type) {
        this.type = type;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    @Override
    public String toString() {
        return "transactions{" +
                "id=" + id +
                ", id_compte=" + id_compte +
                ", label='" + label + '\'' +
                ", montant=" + montant +
                ", date_de_transactions=" + date_de_transactions +
                ", type=" + type +
                ", id_categorie=" + id_categorie +
                '}';
    }
}
