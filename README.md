# Spring ToDo Application

This repository contains a simple ToDo application written in Kotlin using the Spring framework. For the Java version of
the same application, check [this](https://github.com/HibyteIntelli/spring-todo) repository out.

Features of this simple project include:
- connecting to a PostgresSQL database
- CRUD endpoints for a `todo` entity

## Database
In case you don't have a Postgres instance running locally, you can just run this command in the root of the project:

```sh
docker compose -f postgres.yml up -d
```

This will start a Postgres instance on port `5432` with the following credentials:
- **Username**: `postgres`
- **Password**: `admin`
