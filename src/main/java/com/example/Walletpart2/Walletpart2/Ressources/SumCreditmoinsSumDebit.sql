CREATE OR REPLACE FUNCTION get_money_transactions_sum(
    account_id INT,
    start_datetime TIMESTAMP,
    end_datetime TIMESTAMP
) RETURNS DOUBLE PRECISION AS $$
DECLARE
    total_amount DOUBLE PRECISION;
BEGIN
    SELECT COALESCE(SUM(CASE WHEN type_de_transactions = 'CREDIT' THEN montant ELSE -montant END), 0.0)
    INTO total_amount
    FROM transactions
    WHERE id_compte = account_id
        AND date_de_transactions BETWEEN start_datetime AND end_datetime;

    RETURN total_amount;
END;
$$ LANGUAGE plpgsql;

SELECT get_money_transactions_sum(1, '2023-01-01 00:00:00', '2023-12-31 23:59:59') AS total_amount;