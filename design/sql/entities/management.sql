-- Table: public.management

DROP TABLE public.management CASCADE;

CREATE TABLE public.management
(
    id serial NOT NULL,
    name character varying(80)  NOT NULL,
    address_id integer NOT NULL,
    email character varying(80) NULL,
    type character varying(15) NOT NULL,
    rfc character varying(80) NULL,
    phone_number numeric(10,0) NOT NULL,
    mobile_number numeric(10,0) NULL,
    additional_number numeric(10,0) NULL,
    web character varying(180) NULL,
    status integer NOT NULL DEFAULT 1,
    CONSTRAINT management_pk PRIMARY KEY (id),
    CONSTRAINT management_address_fk FOREIGN KEY (address_id)
        REFERENCES public.address (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT type_chk CHECK (type IN ('Persona Física', 'Persona Moral'))
    )
    INHERITS (base_timestamps)
    TABLESPACE pg_default;

CREATE TRIGGER management_time_trg_upd BEFORE UPDATE
    ON public.management FOR EACH ROW
EXECUTE PROCEDURE update_modification_time();

ALTER TABLE IF EXISTS public.management
    OWNER to buildingadmin;