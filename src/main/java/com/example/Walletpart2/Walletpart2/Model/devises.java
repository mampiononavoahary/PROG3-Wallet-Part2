package com.example.Walletpart2.Walletpart2.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


public class devises {
    private int id_devise;
    private NomDevises nomDevises;
    private CodeDevises codeDevises;

    public devises(int id_devise, NomDevises nomDevises, CodeDevises codeDevises) {
        this.id_devise = id_devise;
        this.nomDevises = nomDevises;
        this.codeDevises = codeDevises;
    }

    public int getId_devise() {
        return id_devise;
    }

    public void setId_devise(int id_devise) {
        this.id_devise = id_devise;
    }

    public NomDevises getNomDevises() {
        return nomDevises;
    }

    public void setNomDevises(NomDevises nomDevises) {
        this.nomDevises = nomDevises;
    }

    public CodeDevises getCodeDevises() {
        return codeDevises;
    }

    public void setCodeDevises(CodeDevises codeDevises) {
        this.codeDevises = codeDevises;
    }

    @Override
    public String toString() {
        return "devises{" +
                "id_devise=" + id_devise +
                ", nomDevises=" + nomDevises +
                ", codeDevises=" + codeDevises +
                '}';
    }
}
