#!/usr/bin/env bash
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE DATABASE spicinemas;
    CREATE DATABASE spicinemas_test;

    CREATE ROLE spiuser WITH LOGIN PASSWORD 'spiuser';

    GRANT ALL ON DATABASE spicinemas TO spiuser;
    GRANT ALL ON DATABASE spicinemas_test TO spiuser;
    GRANT ALL ON ALL TABLES IN SCHEMA public to spiuser;
EOSQL