-- Table: public.fila

-- DROP TABLE public.fila;

CREATE TABLE public.fila
(
  id integer NOT NULL,
  descripcion character varying(50),
  CONSTRAINT "PK_id_fila" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.fila
  OWNER TO postgres;
