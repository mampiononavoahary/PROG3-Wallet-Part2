package com.example.Walletpart2.Walletpart2.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class currencyValue {
    private int id;
    private int id_devise_source;
    private int id_devise_destination;
    private Double valeur;
    private Date date_d_effet;
}
