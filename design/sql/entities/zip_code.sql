-- Table: public.zip_code

DROP TABLE public.zip_code CASCADE;

CREATE TABLE public.zip_code
(
    id BIGSERIAL NOT NULL,
    zip_code character varying(5)  NOT NULL,
    neighborhood character varying(80)  NOT NULL,
    municipality_id integer NOT NULL,
    state_id integer NOT NULL,
    country_id integer NOT NULL,
    status integer DEFAULT 1,
    CONSTRAINT zip_code_pk PRIMARY KEY (id),
    CONSTRAINT zip_code_uk UNIQUE (zip_code, neighborhood, municipality_id, state_id, country_id),
    CONSTRAINT zip_code_country_fk FOREIGN KEY (country_id)
    REFERENCES public.country (id) MATCH SIMPLE
                           ON UPDATE NO ACTION
                           ON DELETE NO ACTION,
    CONSTRAINT zip_code_municipality_fk FOREIGN KEY (municipality_id)
    REFERENCES public.municipality (id) MATCH SIMPLE
                           ON UPDATE NO ACTION
                           ON DELETE NO ACTION,
    CONSTRAINT zip_code_state_fk FOREIGN KEY (state_id)
    REFERENCES public.state (id) MATCH SIMPLE
                           ON UPDATE NO ACTION
                           ON DELETE NO ACTION
    )
    INHERITS (base_timestamps)
    TABLESPACE pg_default;

CREATE TRIGGER zip_code_time_trg_upd BEFORE UPDATE
    ON public.zip_code FOR EACH ROW
    EXECUTE PROCEDURE update_modification_time();

ALTER TABLE public.zip_code
    OWNER to buildingadmin;