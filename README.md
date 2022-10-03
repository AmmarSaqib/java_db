# Java with Hibernate ORM

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

