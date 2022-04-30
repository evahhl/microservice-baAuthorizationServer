-- Table: public.address

DROP TABLE IF EXISTS public.address CASCADE;

CREATE TABLE public.address
(
    id BIGSERIAL NOT NULL,
    street_name character varying(80) NOT NULL,
    ext_number character varying(20) NOT NULL,
    int_number character varying(20),
    neighborhood character varying(80) NOT NULL,
    zip_code character varying(5)  NOT NULL,
    municipality_id integer NOT NULL,
    city_id integer NOT NULL,
    state_id integer NOT NULL,
    country_id integer NOT NULL,
    CONSTRAINT address_pk PRIMARY KEY (id),
    CONSTRAINT address_municipality_fk FOREIGN KEY (municipality_id)
        REFERENCES public.municipality(id)
    MATCH SIMPLE
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE,
    CONSTRAINT address_city_fk FOREIGN KEY (city_id)
        REFERENCES public.city(id)
        MATCH SIMPLE
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE,
    CONSTRAINT address_state_fk FOREIGN KEY (state_id)
        REFERENCES public.state(id)
        MATCH SIMPLE
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE,
    CONSTRAINT address_country_fk FOREIGN KEY (country_id)
        REFERENCES public.country(id)
        MATCH SIMPLE
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE
    )
    INHERITS (base_timestamps)
    TABLESPACE pg_default;

CREATE TRIGGER address_time_trg_upd BEFORE UPDATE
    ON public.address FOR EACH ROW
    EXECUTE PROCEDURE update_modification_time();

ALTER TABLE public.address
    OWNER to buildingadmin;