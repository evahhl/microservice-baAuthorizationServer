\echo '###### ******* MAIN: NARTAN BA ****** ######'
\echo 'creating Entities...'
\ir entities/base_timestamps.sql
\ir entities/country.sql
\ir entities/state.sql
\ir entities/city.sql
\ir entities/zip_code.sql
\ir entities/address.sql
\ir entities/building.sql
\ir entities/apartment.sql
\ir entities/parking.sql
\ir entities/user_type.sql
\ir entities/user.sql
\ir entities/user_apartment.sql
\ir entities/management.sql
\ir entities/building_management.sql
\echo 'creating Functions...'
\echo 'creating Triggers...'
\ir triggers/update_modification_time.sql
\echo 'loading data...'
\ir data/data_country.sql
\ir data/data_state.sql
\ir data/data_city.sql
\ir data/data_zip_code.sql
\ir data/data_address.sql
\ir data/data_building.sql
\ir data/data_apartment.sql
\ir data/data_parking.sql
\ir data/data_user_type.sql
\ir data/data_user.sql
\ir data/data_user_apartment.sql
\ir data/data_management.sql
\ir data/data_building_management.sql

