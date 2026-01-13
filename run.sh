#!/bin/bash

docker compose up -d
export DB_PASSWORD=$(docker exec -it api-db cat /run/secrets/pg_password)
./mvnw spring-boot:run
