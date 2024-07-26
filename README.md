# Java api rest

## Get started

### 1. Requirements:
- You need to have [docker](https://docs.docker.com/get-docker/) and [docker compose](https://docs.docker.com/compose/install/) installed.

### 2. Install

```
make build
```

### 3. Init application

```
make run
```

## Swagger

[http://localhost:8080/docs](http://localhost:8080/docs)

## Dependencies
| Service         | Description      | Port |
|-----------------|------------------|------|
| **MySql 8**     | Database         | 4306 |
| **Php MyAdmin** | GUI for database | 4307 |