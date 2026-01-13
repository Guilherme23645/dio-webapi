#!/bin/bash

docker compose up -d
export DB_PASSWORD=$(cat /run/secrets/pg_password)
./mvnw spring-boot:run