CREATE TABLE Categorie(
    id int primary key,
    name VARCHAR(200),
    type VARCHAR(8) CHECK(type IN('incomes','expenses'))
);

INSERT INTO Categorie VALUES(1,'Restaurant','expenses');
INSERT INTO Categorie VALUES(2,'Remboursement','incomes');