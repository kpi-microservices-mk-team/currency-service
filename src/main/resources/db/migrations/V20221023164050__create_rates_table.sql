CREATE TABLE rates (
    effective_date DATE,
    currency VARCHAR(5),
    rate FLOAT
);

ALTER TABLE rates ADD CONSTRAINT rates_pk PRIMARY KEY (effective_date, currency);