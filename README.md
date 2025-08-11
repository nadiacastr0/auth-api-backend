# Backend - API de Autenticação

Este projeto é uma API REST desenvolvida com **Java Spring Boot** para gerenciamento de autenticação de usuários.

## Funcionalidades

* Configuração de uma API REST para autenticação.
* Gerenciamento de autenticação usando **Spring Security**.
* Integração com banco de dados para armazenar informações dos usuários.

## Tecnologias Utilizadas

* Java 17
* Spring Boot
* Spring Security
* Banco de dados in memory H2

## Configuração

1. **Clone o repositório**

```bash
git clone https://github.com/nadiacastr0/auth-api-backend.git

```

2. **Rodar a aplicação**

```bash
./mvnw spring-boot:run
```

ou

```bash
mvn spring-boot:run
```

## Endpoints principais

* `POST /auth/login` - Login do usuário.
* `POST /auth/register` - Registro de um novo usuário.

## Observações

* A autenticação é gerenciada com Spring Security, garantindo segurança e controle de acesso.
* As informações do usuário são armazenadas no banco in memory.

