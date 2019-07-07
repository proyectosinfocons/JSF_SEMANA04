-- Table: public.columna

-- DROP TABLE public.columna;

CREATE TABLE public.columna
(
  id integer NOT NULL,
  descripcion character varying(50),
  nivel integer,
  ancho integer, -- 
  alto integer,
  CONSTRAINT "PK_id_columna" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.columna
  OWNER TO postgres;
COMMENT ON COLUMN public.columna.ancho IS '
';

