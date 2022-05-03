-- Table: public.user_building

-- DROP TABLE public.user CASCADE;

CREATE TABLE public.user
(
    id BIGSERIAL NOT NULL,
    name character varying(80) NOT NULL,
    last_name character varying(80) NOT NULL,
    email character varying(80) NULL,
    phone_number numeric(10,0) NULL,
    mobile_phone numeric(10,0) NULL,
    user_type_id integer NOT NULL,
    status integer NOT NULL DEFAULT 1,
    CONSTRAINT user_pk PRIMARY KEY (id),
    CONSTRAINT user_user_type_fk FOREIGN KEY (user_type_id)
    REFERENCES public.user_type (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
)
    INHERITS (base_timestamps)
    TABLESPACE pg_default;

CREATE TRIGGER user_time_trg_upd BEFORE UPDATE
    ON public.user FOR EACH ROW
EXECUTE PROCEDURE update_modification_time();

ALTER TABLE IF EXISTS public.user_building
    OWNER to buildingadmin;