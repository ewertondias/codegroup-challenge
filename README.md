# Challenge

Project Challenge Code Group

---

## Requisitos

O projeto faz uso de: 
`Spring Boot 3.3.2`
`JDK 17`
`Maven 3.9.6`

- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Flywal](https://flywaydb.org/)
- [PostgreSQL](https://www.postgresql.org/)

---

## Banco de dados da aplicação

`PostgreSQL`
  - URL: jdbc:postgresql://localhost:5432/challenge
  - usuario: postgres
  - senha: postgres

---

## Instalação

### Clone o repositório

```bash
git clone git@github.com:ewertondias/codegroup-challenge.git
```

### Navegue para o diretório do projeto

```bash
cd challenge
```

### Compilar
```bash
mvn clean install
```

#### Instalar challenge-0.0.1-SNAPSHOT.war em um servidor de aplicação ex: tomcat

### Acessar aplicação

```bash
http://localhost:8080/
```
---

## Api rest para cadastro de membros
http://localhost:8080/swagger-ui/index.html

---

## Testes

### Executar os testes

```bash
mvn clean verify
```