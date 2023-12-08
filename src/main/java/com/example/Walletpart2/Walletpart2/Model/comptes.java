package com.example.Walletpart2.Walletpart2.Model;

import lombok.*;

import java.time.LocalDateTime;

public class comptes {
    private int id;

    private String nom_de_compte;
    private double solde;
    private LocalDateTime solde_date_mis_a_jour;
    private int id_devise;

    private typeCompte type;

    public comptes(int id, String nom_de_compte, double solde, LocalDateTime solde_date_mis_a_jour, int id_devise, typeCompte type) {
        this.id = id;
        this.nom_de_compte = nom_de_compte;
        this.solde = solde;
        this.solde_date_mis_a_jour = solde_date_mis_a_jour;
        this.id_devise = id_devise;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_de_compte() {
        return nom_de_compte;
    }

    public void setNom_de_compte(String nom_de_compte) {
        this.nom_de_compte = nom_de_compte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public LocalDateTime getSolde_date_mis_a_jour() {
        return solde_date_mis_a_jour;
    }

    public void setSolde_date_mis_a_jour(LocalDateTime solde_date_mis_a_jour) {
        this.solde_date_mis_a_jour = solde_date_mis_a_jour;
    }

    public int getId_devise() {
        return id_devise;
    }

    public void setId_devise(int id_devise) {
        this.id_devise = id_devise;
    }

    public typeCompte getType() {
        return type;
    }

    public void setType(typeCompte type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "comptes{" +
                "id=" + id +
                ", nom_de_compte='" + nom_de_compte + '\'' +
                ", solde=" + solde +
                ", solde_date_mis_a_jour=" + solde_date_mis_a_jour +
                ", id_devise=" + id_devise +
                ", type=" + type +
                '}';
    }
}
