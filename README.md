# Java with Hibernate ORM

This boiler plate shows an implementation of ORM in java to read a pre-existing database table.


# File Structure

## Setup Docker Buildkit
Set the following variables in the environment:
```
export COMPOSE_DOCKER_CLI_BUILD=1
export DOCKER_BUILDKIT=1
```

## Setup Databases
Manually create a database via Adminer. The code is developed for the following structure:

```
id Integer
name Text
address Text
```

```
CREATE TABLE employees(
   id SERIAL PRIMARY KEY,
   name text,
   address text
);
```

## Our Use Case
We want the service to be able to receive events in a fixed pattern and then parse relevant data 
and that query the database to fetch the relevant ids against that event.
Hence the service will be reading the database for this particular use case.

## Techical Stuff

ORM used in this project is `Hibernate-envers`.
