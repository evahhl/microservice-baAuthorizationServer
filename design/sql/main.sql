\echo '###### ******* MAIN: NARTAN BA ****** ######'
\echo 'creating Entities...'
\ir entities/base_timestamps.sql
\ir entities/country.sql
\ir entities/state.sql
\ir entities/municipality.sql
\ir entities/city.sql
\ir entities/zip_code.sql
\ir entities/address.sql
\ir entities/building.sql
\ir entities/apartment.sql
\ir entities/parking.sql
\echo 'creating Functions...'
\echo 'creating Triggers...'
\ir triggers/update_modification_time.sql
\echo 'loading data...'
\ir data/data_country.sql
\ir data/data_state.sql
\ir data/data_city.sql
\ir data/data_municipality.sql
\ir data/data_zip_code.sql
\ir data/data_address.sql
\ir data/data_building.sql
\ir data/data_apartment.sql
\ir data/data_parking.sql

