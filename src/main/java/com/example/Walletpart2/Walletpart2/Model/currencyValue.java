package com.example.Walletpart2.Walletpart2.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

public class currencyValue {
    private int id;
    private int id_devise_source;
    private int id_devise_destination;
    private Double valeur;
    private Date date_d_effet;

    public currencyValue(int id, int id_devise_source, int id_devise_destination, Double valeur, Date date_d_effet) {
        this.id = id;
        this.id_devise_source = id_devise_source;
        this.id_devise_destination = id_devise_destination;
        this.valeur = valeur;
        this.date_d_effet = date_d_effet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_devise_source() {
        return id_devise_source;
    }

    public void setId_devise_source(int id_devise_source) {
        this.id_devise_source = id_devise_source;
    }

    public int getId_devise_destination() {
        return id_devise_destination;
    }

    public void setId_devise_destination(int id_devise_destination) {
        this.id_devise_destination = id_devise_destination;
    }

    public Double getValeur() {
        return valeur;
    }

    public void setValeur(Double valeur) {
        this.valeur = valeur;
    }

    public Date getDate_d_effet() {
        return date_d_effet;
    }

    public void setDate_d_effet(Date date_d_effet) {
        this.date_d_effet = date_d_effet;
    }

    @Override
    public String toString() {
        return "currencyValue{" +
                "id=" + id +
                ", id_devise_source=" + id_devise_source +
                ", id_devise_destination=" + id_devise_destination +
                ", valeur=" + valeur +
                ", date_d_effet=" + date_d_effet +
                '}';
    }
}
