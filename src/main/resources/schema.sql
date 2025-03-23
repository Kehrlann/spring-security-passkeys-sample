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
CREATE TABLE IF NOT EXISTS user_credentials
(
    credential_id                text    not null PRIMARY KEY,
    user_entity_user_id          text    not null,
    public_key                   bytea   not null,
    signature_count              bigint,
    uv_initialized               boolean,
    backup_eligible              boolean not null,
    authenticator_transports     text,
    public_key_credential_type   text,
    backup_state                 boolean not null,
    attestation_object           bytea,
    attestation_client_data_json bytea,
    created                      timestamp,
    last_used                    timestamp,
    label                        text    not null
);

CREATE TABLE IF NOT EXISTS user_entities
(
    id           TEXT NOT NULL PRIMARY KEY,
    name         TEXT NOT NULL,
    display_name TEXT,
    CONSTRAINT fk_passkeys_users FOREIGN KEY (name) REFERENCES users (username)

);
