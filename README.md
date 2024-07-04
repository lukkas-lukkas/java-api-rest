# Java api rest

## Instalação

### 1. Pré requisitos:
- É preciso ter o [docker](https://docs.docker.com/get-docker/) e o [docker compose](https://docs.docker.com/compose/install/) instalados.

### 2. Instalar

```
make build
```

### 3. Iniciar a aplicação

```
make run
```

## Dependências
| Serviço         | Descrição                 | Porta |
|-----------------|---------------------------|-------|
| **MySql 8**     | Banco de dados            | 4306  |
| **Php MyAdmin** | GUI para o banco de dados | 4307  |

## Requisições

| Descrição              | Arquivo                                                        |
|------------------------|----------------------------------------------------------------|
| Criar uma pessoa       | [.requests/person/create.http](.requests/person/create.http)   |
| Buscar todas as pessoas | [.requests/person/get-all.http](.requests/person/get-all.http) |