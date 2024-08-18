[![Continuous Integration with GitHub, GitHub Actions and Docker Hub](https://github.com/Edvan-Oliveira/microservices-udemy-eurudio/actions/workflows/docker-publish.yml/badge.svg)](https://github.com/Edvan-Oliveira/microservices-udemy-eurudio/actions/workflows/docker-publish.yml)

# 📝 Sobre

Este é um projeto de microsserviços, desenvolvido com o framework [Spring Boot](https://spring.io/projects/spring-boot). 
O objetivo deste projeto é demonstrar as boas práticas de uma arquitetura de microsserviços.

<br/>

# 🕸️ Componentes da Arquitetura

### ✨naming-service

Responsável pelo registro dos serviços, permitindo que eles se encontrem apenas por seus nomes.

| URL do Eureka           | 
|-------------------------|
| http://localhost:8761   |

<img src="https://github.com/Edvan-Oliveira/imagens/blob/main/microservices-udemy-eurudio/eureka.png?raw=true" alt="Eureka">

### ✨api-gateway

Centraliza as requisições e faz o roteamento para os serviços.

| URL do Swagger                        | 
|---------------------------------------|
| http://localhost:8765/swagger-ui.html |

<img src="https://github.com/Edvan-Oliveira/imagens/blob/main/microservices-udemy-eurudio/swagger.png?raw=true" alt="Swagger API Gateway">

### ✨Zipkin

Junto com o Micrometer, identificam e mapeiam as requisições entre os serviços, facilitando a identificação de falhas.

| URL do Swagger                        | 
|---------------------------------------|
| http://localhost:8765/swagger-ui.html |

<img src="https://github.com/Edvan-Oliveira/imagens/blob/main/microservices-udemy-eurudio/zipkin.png?raw=true" alt="Zipkin">

<img src="https://github.com/Edvan-Oliveira/imagens/blob/main/microservices-udemy-eurudio/zipkin-show.png?raw=true" alt="Detalhes de uma requisição">

### ✨RabbitMQ

Ajuda na consistência dos dados enviados ao Zipkin, segura os logs na fila caso do Zipkin caia.

| URL do RabbitMQ         | 
|-------------------------|
| http://localhost:15672/ |

<img src="https://github.com/Edvan-Oliveira/imagens/blob/main/microservices-udemy-eurudio/rabbitmq.png?raw=true" alt="RabbitMQ">

### ✨cambio-service

Serviço responsável por realizar a conversão entre moedas.

| Assinatura da URL                    | Exemplo de chamada                              |
|--------------------------------------|-------------------------------------------------|
| /cambio-service/{amount}/{from}/{to} | http://localhost:8000/cambio-service/10/USD/BRL |

<img src="https://github.com/Edvan-Oliveira/imagens/blob/main/microservices-udemy-eurudio/cambio-service.png?raw=true" alt="cambio-service">

### ✨book-service

Serviço responsável por buscar um livro e retornar seu valor na moeda informada.

| Assinatura da URL               | Exemplo de chamada                        |
|---------------------------------|-------------------------------------------|
| /book-service/{id}/{currency}   | http://localhost:8100/book-service/5/BRL  |

<img src="https://github.com/Edvan-Oliveira/imagens/blob/main/microservices-udemy-eurudio/book-service.png?raw=true" alt="book-service">

<br/>

# 🚀 Tecnologias utilizadas

- Java 21
- Spring Boot 3.3.2
- MySQL
- Spring Cloud API Gateway
- Spring Cloud Eureka
- Spring Cloud Config Server
- Spring Cloud OpenFeign
- Resilience4j
- Swagger (springdoc)
- Zipkin - Distributed Tracing Server
- Micrometer Tracing Bridge Brave
- RabbitMQ
- Docker
- GitHub Actions
- Spring Data JPA
- Lombok
- Maven

<br/>

# 👓 Instruções de como rodar o projeto localmente em sua máquina

## Execução Rápida

Para executar o projeto de foram rápida apenas será preciso o [Docker](https://www.docker.com) e o [GIT](https://git-scm.com/) instalados,
e em seguida executar os comandos abaixo:

```bash
$ git clone https://github.com/Edvan-Oliveira/microservices-udemy-eurudio.git

$ cd microservices-udemy-eurudio/demo

$ docker-compose up -d
```

## Executar com Alterações

Caso queira o código para modificar e testar, será necessário o [Docker](https://www.docker.com), [GIT](https://git-scm.com/),
[Java](https://www.java.com/pt-BR/) e o [Maven](https://maven.apache.org/) instalados, e em seguida executar os comandos abaixo: 

```bash
$ git clone https://github.com/Edvan-Oliveira/microservices-udemy-eurudio.git
$ cd microservices-udemy-eurudio

$ cd naming-server
$ mvn spring-boot:build-image -DskipTests

$ cd ../api-gateway
$ mvn spring-boot:build-image -DskipTests

$ cd ..
$ docker-compose up -d --build
```

## Parar a Execução

Para parar a execução dos serviços, basta executar o comando abaixo:

```bash
$ docker-compose down
```

<br/>

# Contatos

<div>
    <a href="https://www.linkedin.com/in/edvan-oliveira-0822b2227/" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a>
  <a href = "mailto:edvan.oliveiract@gmail.com"><img src="https://img.shields.io/badge/-Gmail-%23333?style=for-the-badge&logo=gmail&logoColor=white" target="_blank"></a>
  <a href = "https://t.me/Edvan_Oliveira"><img src="https://img.shields.io/badge/Telegram-2CA5E0?style=for-the-badge&logo=telegram&logoColor=white" target="_blank"></a>

</div>
