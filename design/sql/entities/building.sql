-- Table: public.building

DROP TABLE public.building CASCADE;

CREATE TABLE public.building
(
    id BIGSERIAL NOT NULL,
    name character varying(80) NOT NULL,
    address_id integer NOT NULL,
    phone_number character varying(10) NOT NULL,
    email character varying(80)  NOT NULL,
    status integer NOT NULL DEFAULT 1,
    CONSTRAINT building_pk PRIMARY KEY (id)
    )
    INHERITS (base_timestamps)
    TABLESPACE pg_default;

CREATE TRIGGER building_time_trg_upd BEFORE UPDATE
    ON public.building FOR EACH ROW
    EXECUTE PROCEDURE update_modification_time();

ALTER TABLE IF EXISTS public.building
    OWNER to buildingadmin;