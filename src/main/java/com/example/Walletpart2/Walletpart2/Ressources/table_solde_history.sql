CREATE TABLE IF NOT EXISTS SoldeHistoique (
    id int PRIMARY KEY,
    id_compte int REFERENCES compte(id),
    transaction_id INT REFERENCES transactions(id),
    balance double precision NOT NULL,
    date TIMESTAMP NOT NULL
);