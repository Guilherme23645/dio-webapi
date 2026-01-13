#!/bin/bash

docker compose up -d
export DB_PASSWORD=$(cat /home/gui/dio-webapi/pg_password.txt)
./mvnw spring-boot:run