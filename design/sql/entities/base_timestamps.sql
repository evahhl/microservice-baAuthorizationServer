--DROP TABLE IF EXISTS base_timestamps CASCADE;

CREATE TABLE base_timestamps (
  creation_time timestamp with time zone NOT NULL DEFAULT now(),
  modification_time timestamp with time zone NOT NULL DEFAULT now(),
  CONSTRAINT base_time_chk CHECK(modification_time >= creation_time)
);

/*****************************************************************************
 * Security                                                                  *
 *****************************************************************************/

ALTER TABLE base_timestamps OWNER TO buildingadmin;