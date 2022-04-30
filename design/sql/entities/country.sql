-- Table: public.country

--DROP TABLE public.country CASCADE;

CREATE TABLE public.country
(
    id BIGSERIAL NOT NULL,
    country_name character varying(80) NOT NULL,
    status integer DEFAULT 1,
    CONSTRAINT country_pk PRIMARY KEY (id),
    CONSTRAINT country_uk UNIQUE (country_name)
    )
    INHERITS (base_timestamps)
    TABLESPACE pg_default;

CREATE TRIGGER country_time_trg_upd BEFORE UPDATE
    ON public.country FOR EACH ROW
EXECUTE PROCEDURE update_modification_time();

ALTER TABLE public.country
    OWNER to buildingadmin;