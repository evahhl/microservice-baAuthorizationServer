-- Table: public.city

DROP TABLE public.city CASCADE;

CREATE TABLE public.city
(
    id BIGSERIAL NOT NULL,
    city_name character varying(80) NULL,
    municipality_name character varying(80) NOT NULL,
    state_id integer NOT NULL,
    status integer DEFAULT 1,
    CONSTRAINT city_pk PRIMARY KEY (id),
    CONSTRAINT city_state_fk FOREIGN KEY (state_id)
    REFERENCES public.state(id)
        MATCH SIMPLE
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE
    )
    INHERITS (base_timestamps)
    TABLESPACE pg_default;

CREATE TRIGGER city_time_trg_upd BEFORE UPDATE
    ON public.city FOR EACH ROW
    EXECUTE PROCEDURE update_modification_time();

ALTER TABLE public.city
    OWNER to buildingadmin;
