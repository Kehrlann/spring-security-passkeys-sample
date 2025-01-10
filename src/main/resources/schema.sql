--- Spring Security JDBC DDL
CREATE TABLE IF NOT EXISTS users
(
    username TEXT    NOT NULL PRIMARY KEY,
    password TEXT    NOT NULL,
    enabled  BOOLEAN NOT NULL
);
CREATE TABLE IF NOT EXISTS authorities
(
    username  TEXT NOT NULL,
    authority TEXT NOT NULL,
    CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users (username)
);
CREATE UNIQUE INDEX IF NOT EXISTS ix_auth_username ON authorities (username, authority);

-- Passkeys DDL
CREATE TABLE IF NOT EXISTS public_key_user
(
    id           BYTEA UNIQUE NOT NULL,
    name         TEXT         NOT NULL,
    display_name TEXT
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