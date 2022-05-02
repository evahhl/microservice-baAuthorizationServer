-- Table: public.parking

DROP TABLE public.parking CASCADE;

CREATE TABLE public.parking
(
    id BIGSERIAL NOT NULL,
    parking_number character varying(5) NOT NULL,
    building_id integer NOT NULL,
    apartment_id integer NULL,
    location character varying(80)  NULL,
    status integer NOT NULL DEFAULT 1,
    CONSTRAINT parking_pk PRIMARY KEY (id),
    CONSTRAINT parking_uk UNIQUE (parking_number, building_id, apartment_id),
    CONSTRAINT parking_building_fk FOREIGN KEY (building_id)
    REFERENCES public.building (id) MATCH SIMPLE
       ON UPDATE NO ACTION
       ON DELETE NO ACTION,
    CONSTRAINT parking_apartment_fk FOREIGN KEY (apartment_id)
    REFERENCES public.apartment (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
    )
    INHERITS (base_timestamps)
    TABLESPACE pg_default;

CREATE TRIGGER parking_time_trg_upd BEFORE UPDATE
    ON public.parking FOR EACH ROW
EXECUTE PROCEDURE update_modification_time();

ALTER TABLE IF EXISTS public.parking
    OWNER to buildingadmin;