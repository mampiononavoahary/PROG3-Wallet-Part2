
CREATE TABLE transfer_history (
    id SERIAL PRIMARY KEY,
    id_transaction_debiteur INT REFERENCES transactions(id),
    id_transaction_crediteur INT REFERENCES transactions(id),
    date_du_transfert TIMESTAMP
);