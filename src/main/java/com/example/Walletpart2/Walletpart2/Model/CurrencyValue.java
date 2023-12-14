package com.example.Walletpart2.Walletpart2.Model;

import java.time.LocalDateTime;
import java.util.Date;

public class CurrencyValue {
    private String id;
    private int id_devise_source;
    private int getId_devise_destination;
    private double valeur;
    private Date date_d_effet;

    public CurrencyValue(String id, int id_devise_source, int getId_devise_destination, double valeur, Date date_d_effet) {
        this.id = id;
        this.id_devise_source = id_devise_source;
        this.getId_devise_destination = getId_devise_destination;
        this.valeur = valeur;
        this.date_d_effet = date_d_effet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getId_devise_source() {
        return id_devise_source;
    }

    public void setId_devise_source(int id_devise_source) {
        this.id_devise_source = id_devise_source;
    }

    public int getGetId_devise_destination() {
        return getId_devise_destination;
    }

    public void setGetId_devise_destination(int getId_devise_destination) {
        this.getId_devise_destination = getId_devise_destination;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
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
        return "CurrencyValue{" +
                "id='" + id + '\'' +
                ", id_devise_source=" + id_devise_source +
                ", getId_devise_destination=" + getId_devise_destination +
                ", valeur=" + valeur +
                ", date_d_effet=" + date_d_effet +
                '}';
    }
}
