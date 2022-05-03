-- Table: public.user_apartment

DROP TABLE public.user_apartment CASCADE;

CREATE TABLE public.user_apartment
(
    id BIGSERIAL NOT NULL,
    building_id integer NOT NULL,
    user_id integer NOT NULL,
    apartment_id integer NOT NULL,
    CONSTRAINT user_apartment_pk PRIMARY KEY (id),
    CONSTRAINT user_apartment_building_fk FOREIGN KEY (building_id)
        REFERENCES public.building (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT user_apartment_fk FOREIGN KEY (apartment_id)
        REFERENCES public.apartment (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT user_apartment_uk UNIQUE (user_id,building_id,apartment_id)
    )
    INHERITS (base_timestamps)
    TABLESPACE pg_default;

CREATE TRIGGER user_apartment_time_trg_upd BEFORE UPDATE
    ON public.user_apartment FOR EACH ROW
EXECUTE PROCEDURE update_modification_time();

ALTER TABLE IF EXISTS public.user_apartment
    OWNER to buildingadmin;