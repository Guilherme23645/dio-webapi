# dio-webapi

## Overview

REST API for CEPs (brazilian postal codes) that consumes an external API, ViaCEP, to get them and implement CRUD into a relational database.

## Tools

- **Spring Boot**: Java framework to simplify the development of resilient, enterprise-oriented, back-end applications.
- **PostgreSQL**: Object-Relational Database Management System
- **Docker**: Containerization tool used here to host the database
- **Swagger**: Documentation tool for APIs
- **Adminer**: UI platform for the database that simplifies its management

## Pre-requisites

- Java Development Kit (JDK) version 21
- Docker Compose

*Note: If you're not in a Linux environment, you can install PostgreSQL and a UI database platform locally.*

## Instructions

- Before running the app, create a pg_password.txt file on the directory's root and write the password of your choice in it. This will be your secret for the app and the containers.
- Execute the local running script with this set of commands:
```
# At the directory's root
chmod +x run.sh
./run.sh
```
- Then, all parts of the program will start running at the ports below:
  - REST API: http://your-ip:8081/clientes
  - Swagger UI: http://your-ip:8081/swagger-ui.html
  - Adminer: http://your-ip:9000
- To log into the database with Adminer follow the steps below:
  - Click the database dropdown and select "PostgreSQL"
  - As the server's name, use "api-db"
  - For the user, use the default which is "postgres"
  - Insert the password within the pg_password.txt file, watch out for carriage returns (CRLF)
  - Insert the database's name, "client_database"
  - Press the login button

## Screenshots

### Code

<img width="1280" height="862" alt="image" src="https://github.com/user-attachments/assets/0143aa8c-3edb-40d4-b8b1-65f7c5fd7590" />

### Swagger

<img width="1280" height="865" alt="image" src="https://github.com/user-attachments/assets/0c66f9ef-3773-413b-9d4a-19c0d1285d56" />

### Adminer

<img width="1280" height="864" alt="image" src="https://github.com/user-attachments/assets/ae4bebbe-2bcb-45ec-8633-14b6b1e40a10" />
