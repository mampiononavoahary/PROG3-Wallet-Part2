package com.example.Walletpart2.Walletpart2.Model;

import java.time.LocalDateTime;

public class SoldeHistorique {
    private LocalDateTime date;
    private Double montant;

    public SoldeHistorique(LocalDateTime date, Double montant) {
        this.date = date;
        this.montant = montant;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "SoldeHistorique{" +
                "date=" + date +
                ", montant=" + montant +
                '}';
    }
}
