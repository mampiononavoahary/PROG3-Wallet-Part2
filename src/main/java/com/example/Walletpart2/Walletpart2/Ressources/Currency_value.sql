CREATE TABLE currency_value (
    id SERIAL PRIMARY KEY,
    id_devise_source INT REFERENCES devises(devise_id),
    id_devise_destination INT REFERENCES devises(devise_id),
    valeur DOUBLE PRECISION,
    date_d_effet DATE
);