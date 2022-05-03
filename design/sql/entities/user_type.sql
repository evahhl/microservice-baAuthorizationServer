-- Table: public.user_type

DROP TABLE public.user_type CASCADE;

CREATE TABLE public.user_type
(
    id SERIAL NOT NULL,
    description character varying(80) NOT NULL,
    status integer DEFAULT 1,
    CONSTRAINT user_type_pk PRIMARY KEY (id)
    )
    INHERITS (base_timestamps)
    TABLESPACE pg_default;

CREATE TRIGGER user_type_time_trg_upd BEFORE UPDATE
    ON public.user_type FOR EACH ROW
EXECUTE PROCEDURE update_modification_time();

ALTER TABLE IF EXISTS public.user_type
    OWNER to buildingadmin;