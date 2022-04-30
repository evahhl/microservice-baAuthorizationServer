\echo '###### ******* MAIN: NARTAN BA ****** ######'
\echo 'creating Entities...'
\ir entities/base_timestamps.sql
\ir entities/address.sql
\ir entities/apartment.sql
\echo 'creating Functions...'
\echo 'creating Triggers...'
\ir triggers/update_modification_time.sql

