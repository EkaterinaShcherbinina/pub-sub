DROP TABLE IF EXISTS purchase;
DROP TABLE IF EXISTS subscription;

CREATE TABLE IF NOT EXISTS purchase
(
    id BIGSERIAL PRIMARY KEY,
    message_id BIGINT UNIQUE,
    msisdn BIGINT,
    modify_time BIGINT
);

CREATE TABLE IF NOT EXISTS subscription
(
    id BIGSERIAL PRIMARY KEY,
    message_id BIGINT UNIQUE,
    msisdn BIGINT,
    modify_time BIGINT
);