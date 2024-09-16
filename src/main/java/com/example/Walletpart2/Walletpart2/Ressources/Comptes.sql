CREATE TABLE compte (
    id SERIAL PRIMARY KEY,
    nom_de_compte VARCHAR(100) CHECK (nom_de_compte IN ('compte courant', 'compte epargne')),
    solde DOUBLE PRECISION,
    solde_date_mis_a_jour TIMESTAMP,
    devise_id INT REFERENCES devises(devise_id),
    type_compte typedecompte
);