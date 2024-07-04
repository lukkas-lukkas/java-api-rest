# Java api rest

## Get started

### 1. Requirements:
- You need [docker](https://docs.docker.com/get-docker/) and [docker compose](https://docs.docker.com/compose/install/) installed.

### 2. Install

```
make build
```

### 3. Init application

```
make run
```

## Dependencies
| Service         | Description      | Port |
|-----------------|------------------|------|
| **MySql 8**     | Database         | 4306 |
| **Php MyAdmin** | GUI for database | 4307 |

## Requests

### Person

| Description    | File                                                           |
|----------------|----------------------------------------------------------------|
| Create person  | [.requests/person/create.http](.requests/person/create.http)   |
| Delete person  | [.requests/person/delete.http](.requests/person/delete.http)   |
| Get person     | [.requests/person/get.http](.requests/person/get.http)         |
| Get all people | [.requests/person/get-all.http](.requests/person/get-all.http) |
| Update person  | [.requests/person/update.http](.requests/person/update.http)   |

### Others

| Description     | File                                               |
|-----------------|----------------------------------------------------|
| Math operations | [.requests/math.http](.requests/math.http)         |
| Greeting        | [.requests/greeting.http](.requests/greeting.http) |
