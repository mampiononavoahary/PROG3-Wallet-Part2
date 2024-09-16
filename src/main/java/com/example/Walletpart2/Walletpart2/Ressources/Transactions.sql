CREATE TABLE transactions (
    id SERIAL PRIMARY KEY,
    id_compte INT REFERENCES compte(id),
    label VARCHAR(50),
    montant DOUBLE PRECISION,
    date_de_transactions TIMESTAMP,
    type_de_transactions typedetransaction
);