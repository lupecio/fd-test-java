# Getting started

## Requirements

Antes de rodar a aplicação é preciso garantir que as seguintes dependências estejam corretamente instaladas:

```
Java
PostgreSQL
Maven
```

## Database

Create database on postgres

```
CREATE DATABASE "fd-test-java";
```

## Installation

Clone the repository:

```
https://github.com/lupecio/fd-test-java
```

Open project with Eclipse

Install dependencies

Run as Spring Boot App

# Using API

## Create User

Send a POST request to http://localhost:8080/users with test values

    {
        "name": "Lucas",
        "email": "lucas@teste.com",
        "password": "123456",
        "password_confirmation": "123456"
    }

# Testing API

Run test folder with JUnit
