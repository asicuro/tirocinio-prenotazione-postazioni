Create  Table utente(
    id BIGINT NOT NULL,
    username VARCHAR(255),
    pwd VARCHAR(255),
    ruolo VARCHAR(255),
    Primary key(id)
);

Create TABLE ufficio(
    id BIGINT NOT NULL,
    create_user_id BIGINT,
    create_date TIMESTAMP,
    edit_user_id BIGINT,
    edit_date TIMESTAMP,
    indirizzo VARCHAR(255),
    nome_ufficio VARCHAR(255),
    Primary key(id)
);

CREATE TABLE stanza(
    id BIGINT NOT NULL,
    create_user_id BIGINT,
    create_date TIMESTAMP,
    edit_user_id BIGINT,
    edit_date TIMESTAMP,
    name VARCHAR(255),
    width FLOAT,
    height FLOAT,
    x FLOAT,
    y FLOAT,
    Primary key (id),
    ufficio_id BIGINT NOT NULL,
    FOREIGN KEY (ufficio_id) REFERENCES ufficio(id)
);

CREATE TABLE postazione(
    id BIGINT NOT NULL,
    create_user_id BIGINT,
    create_date TIMESTAMP,
    edit_user_id BIGINT,
    edit_date TIMESTAMP,
    width FLOAT,
    height FLOAT,
    x FLOAT ,
    y FLOAT ,
    stanza_id BIGINT NOT NULL,
    FOREIGN KEY (stanza_id) REFERENCES stanza(id),
    Primary key (id)
);

CREATE TABLE prenotazione(
    id BIGINT NOT NULL PRIMARY KEY,
    create_user_id BIGINT,
    create_date TIMESTAMP,
    edit_user_id BIGINT,
    edit_date TIMESTAMP,
    data_creazione Date,
    user_id BIGINT,
    postazione_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES utente(id),
    FOREIGN KEY (postazione_id) REFERENCES postazione(id)
);