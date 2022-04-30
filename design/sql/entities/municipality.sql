-- Table: public.municipality

--DROP TABLE public.municipality CASCADE;

CREATE TABLE public.municipality
(
    id BIGSERIAL NOT NULL,
    municipality_name character varying(80)  NOT NULL,
    state_id integer NOT NULL,
    status integer DEFAULT 1,
    CONSTRAINT municipality_pk PRIMARY KEY (id),
    CONSTRAINT municipality_uk UNIQUE (municipality_name, state_id),
    CONSTRAINT municipality_state_fk FOREIGN KEY (state_id)
        REFERENCES public.state(id)
        MATCH SIMPLE
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE
    )
    INHERITS (base_timestamps)
    TABLESPACE pg_default;

CREATE TRIGGER municipality_time_trg_upd BEFORE UPDATE
    ON public.municipality FOR EACH ROW
    EXECUTE PROCEDURE update_modification_time();

ALTER TABLE public.municipality
    OWNER to buildingadmin;