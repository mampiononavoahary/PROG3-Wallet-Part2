package com.example.Walletpart2.Walletpart2.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class devises {
    private int id_devise;
    private NomDevises nomDevises;
    private CodeDevises codeDevises;
}
