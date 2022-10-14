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

## Code Organisation

- **resources -> META-INF/persistence.xml**: this file is the main file that Hibernate loads to create DB connection also the file maintains the list of DB Models on which the DB tables are mapped as objects.

The model mapping line here is:
```
<class>com.venturenox.app.model.dtos.Employee</class>
```

The `<properties></properties>` scope contains the basic connection and driver specifications for the database.

The driver specifying line is as follows:
```
<property name="jakarta.persistence.jdbc.driver" value="org.postgresql.Driver" />
```

- **app -> DbConfig.java**: The class here connects to the database and gives out the entity manager and factory which are needed to establish the connection and mapping. The class also returns the entity manager onto which transactions are executes per query. 
Note: a new entity manager is used from the same config object for queries.

- **app -> model/dtos/Employee.java**: the files in this directory is for creating models that map onto the database tables. The classes here are annontated via tags specified by `jakarta.persistence`.

- **app -> utils/dbmanagers/EmployeesDBMan.java**: this file is an example of how to interact with the database table using `HQL` and `Criteria Builder`. The managers will use the entity manager and commit transactions on it. The DB Manager will contain functions that define whichc queries are being performed on the table. For every table there will be a separate DB Manager.*

- **app -> Main.java**: Contains the example driver code.

## Techical Stuff
ORM used in this project is `Hibernate-envers`.
The ORM provides a lot of ways to query stuff, but since our company convention is use query builders and function i have used the `criteria query` method along with `HQL` (only when its usage its very minimal).


