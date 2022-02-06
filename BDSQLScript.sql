CREATE DATABASE coopeuch
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

GRANT ALL ON DATABASE coopeuch TO postgres;

GRANT TEMPORARY, CONNECT ON DATABASE coopeuch TO PUBLIC;


-- Table: public.tarea

-- DROP TABLE IF EXISTS public.tarea;

CREATE TABLE IF NOT EXISTS public.tarea
(
    id bigint NOT NULL,
    descripcion character varying(255) COLLATE pg_catalog."default",
    fecha_creacion date,
    vigente boolean,
    CONSTRAINT tarea_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tarea
    OWNER to postgres;