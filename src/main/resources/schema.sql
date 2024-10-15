CREATE TABLE IF NOT EXISTS app_user
(
    id       SERIAL PRIMARY KEY NOT NULL,
    username TEXT UNIQUE        NOT NULL,
    password TEXT               NOT NULL
);

CREATE TABLE IF NOT EXISTS credentials_record
(
    credential_id               BYTEA UNIQUE NOT NULL,
    signature_count             INT          NOT NULL,
    uv_initialized              BOOLEAN,
    backup_eligible             BOOLEAN,
    backup_state                BOOLEAN,
    user_entity_user_id         BYTEA        NOT NULL,
    attestation_object          BYTEA        NOT NULL,
    attestation_client_datajson BYTEA        NOT NULL,
    public_key_cose             BYTEA        NOT NULL,
    label                       TEXT         NOT NULL,
    transports                  TEXT,
    last_used                   TIMESTAMP,
    created                     TIMESTAMP
);

CREATE TABLE IF NOT EXISTS public_key_user
(
    id           BYTEA UNIQUE NOT NULL,
    name         TEXT         NOT NULL,
    display_name TEXT
);



--
-- CREATE TABLE IF NOT EXISTS "login_code"
-- (
--     id              UUID PRIMARY KEY NOT NULL,
--     user_id         UUID             NOT NULL REFERENCES app_user (id),
--     expiration_time TIMESTAMP DEFAULT (now() + INTERVAL '5 minutes')
-- );
--
-- CREATE TABLE IF NOT EXISTS "authenticator"
-- (
--     id                 TEXT PRIMARY KEY NOT NULL,
--     user_id            UUID             NOT NULL REFERENCES app_user (id),
--     credentials_name   TEXT             NOT NULL,
--     attestation_object BYTEA DEFAULT NULL
-- )