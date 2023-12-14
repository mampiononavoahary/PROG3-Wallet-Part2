CREATE TABLE IF NOT EXISTS  transfer_history(
     id INT PRIMARY KEY ,
   id_compte_crediteur int REFERENCES compte(id) NOT NULL,
   id_compte_debiteur int REFERENCES compte(id) NOT NULL,
    valeur double precision,
    date_de_transfert TIMESTAMP
);