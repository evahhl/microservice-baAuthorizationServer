-- Table: public.apartment

DROP TABLE IF EXISTS public.apartment CASCADE;

CREATE TABLE public.apartment
(
    id BIGSERIAL NOT NULL,
    number character varying(5) NOT NULL,
    building_id integer NOT NULL,
    room_number integer NOT NULL,
    bathroom_number integer NOT NULL,
    size integer NOT NULL,
    parking_number integer NOT NULL,
    location character varying(80) NOT NULL,
    balcony_number integer NOT NULL,
    CONSTRAINT apartment_building_fk FOREIGN KEY (building_id)
    REFERENCES public.building (id) MATCH SIMPLE
                           ON UPDATE NO ACTION
                           ON DELETE NO ACTION
    )
    INHERITS (base_timestamps)
    TABLESPACE pg_default;

CREATE TRIGGER apartment_time_trg_upd BEFORE UPDATE
    ON public.apartment FOR EACH ROW
    EXECUTE PROCEDURE update_modification_time();

ALTER TABLE public.apartment
    OWNER to buildingadmin;