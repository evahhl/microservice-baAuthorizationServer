-- Table: public.building_management

DROP TABLE public.building_management CASCADE;

CREATE TABLE public.building_management
(
    id SERIAL NOT NULL,
    building_id integer NOT NULL,
    user_id integer NOT NULL,
    management_id integer NOT NULL,
    CONSTRAINT building_management_pk PRIMARY KEY (id),
    CONSTRAINT building_management_bu_fk FOREIGN KEY (building_id)
    REFERENCES public.building (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT building_user_fk FOREIGN KEY (user_id)
    REFERENCES public.user (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT building_management_ma_fk FOREIGN KEY (management_id)
        REFERENCES public.management (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
    )
    INHERITS (base_timestamps)
    TABLESPACE pg_default;

CREATE TRIGGER building_management_trg_upd BEFORE UPDATE
    ON public.building_management FOR EACH ROW
EXECUTE PROCEDURE update_modification_time();