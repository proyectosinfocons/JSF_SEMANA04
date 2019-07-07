-- Table: public.celda

-- DROP TABLE public.celda;

CREATE TABLE public.celda
(
  idfila integer NOT NULL,
  idcolumna integer NOT NULL,
  valor character varying,
  CONSTRAINT celda_pkey PRIMARY KEY (idfila, idcolumna)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.celda
  OWNER TO postgres;
