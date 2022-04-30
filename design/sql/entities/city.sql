-- Table: public.city

DROP TABLE public.city CASCADE;

CREATE TABLE public.city
(
    id BIGSERIAL NOT NULL,
    city_name character varying(80)  NOT NULL,
    status integer DEFAULT 1,
    CONSTRAINT city_pk PRIMARY KEY (id)
    )
    INHERITS (base_timestamps)
    TABLESPACE pg_default;

CREATE TRIGGER city_time_trg_upd BEFORE UPDATE
    ON public.city FOR EACH ROW
    EXECUTE PROCEDURE update_modification_time();

ALTER TABLE public.city
    OWNER to buildingadmin;