SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;

SET search_path = public, pg_catalog;

CREATE SEQUENCE documentos_seq;

CREATE TABLE documentos(
    id BIGINT NOT NULL DEFAULT NEXTVAL('documentos_seq'),
    codigo_postagem VARCHAR,
    peso NUMERIC(10, 5),
    nome_destinatario VARCHAR,
	logradouro_destinatario VARCHAR,
	numero_destinatario VARCHAR,
	complemento_destinatario VARCHAR,
	bairro_destinatario VARCHAR,
	cidade_destinatario VARCHAR,
	uf_destinatario VARCHAR(2),
	cep_destinatario INTEGER,
	PRIMARY KEY (id)
	UNIQUE (codigo_postagem)
);

CREATE SEQUENCE historico_seq;

CREATE TABLE historico_postagem(
    id BIGINT NOT NULL DEFAULT NEXTVAL('historico_seq'),
    documento_id BIGINT NOT NULL,
    data_hora_movimento TIMESTAMP NOT NULL,
    comentario VARCHAR NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (documento_id) REFERENCES documentos,
    UNIQUE (id, documento_id)
);