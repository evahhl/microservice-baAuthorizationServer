-- Table: public.state

DROP TABLE public.state CASCADE;

CREATE TABLE public.state
(
    id BIGSERIAL NOT NULL,
    state_name character varying(80) NOT NULL,
    country_id integer NOT NULL DEFAULT 1,
    status integer DEFAULT 1,
    CONSTRAINT state_pk PRIMARY KEY (id),
    CONSTRAINT state_uk UNIQUE (state_name, country_id),
    CONSTRAINT state_country_fk FOREIGN KEY (country_id)
    REFERENCES public.country (id) MATCH SIMPLE
                           ON UPDATE NO ACTION
                           ON DELETE NO ACTION
    )
    INHERITS (base_timestamps)
    TABLESPACE pg_default;

CREATE TRIGGER state_time_trg_upd BEFORE UPDATE
    ON public.state FOR EACH ROW
    EXECUTE PROCEDURE update_modification_time();

ALTER TABLE public.state
    OWNER to buildingadmin;