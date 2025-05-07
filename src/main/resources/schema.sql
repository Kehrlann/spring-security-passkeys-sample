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
    -- Primary key
    credential_id                text    not null PRIMARY KEY,

    -- Foreign key
    user_entity_user_id          text    not null,

    -- All the data to perform passkeys signin
    attestation_object           bytea,

    -- Metadata
    created                      timestamp,
    last_used                    timestamp,
    label                        text    not null,

    -- Extra security feature
    signature_count              bigint,

    -- What's this? What's this? There's data everywhere!
    public_key                   bytea   not null,
    uv_initialized               boolean,
    backup_eligible              boolean not null,
    authenticator_transports     text,
    public_key_credential_type   text,
    backup_state                 boolean not null,
    attestation_client_data_json bytea
);

CREATE TABLE IF NOT EXISTS user_entities
(
    id           TEXT NOT NULL PRIMARY KEY,
    name         TEXT NOT NULL,
    display_name TEXT,
    CONSTRAINT fk_passkeys_users FOREIGN KEY (name) REFERENCES users (username)

);
