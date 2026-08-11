# 🛒 E-Commerce API

API REST de **E-Commerce desenvolvida em Java e Spring Boot**, utilizando **Clean Architecture** como principal padrão arquitetural.

O projeto tem como objetivo aplicar, na prática, conceitos de **engenharia de software**, **arquitetura de sistemas**, **segurança**, **performance**, **escalabilidade**, **testes** e **sistemas distribuídos**, indo além de uma aplicação CRUD tradicional.

---

## 🏗️ Clean Architecture

A aplicação utiliza **Clean Architecture**, mantendo as **regras de negócio isoladas de frameworks, bancos de dados e tecnologias externas**.

O projeto aplica principalmente o conceito de **Dependency Inversion**, fazendo com que o núcleo da aplicação dependa de **abstrações**, enquanto as implementações ficam nas camadas externas.

A estrutura segue, de forma geral:

```text
Presentation
     ↓
Application
     ↓
Core / Domain
     ↑
Infrastructure
```

---

## 🚀 Tecnologias e Conceitos

### ☕ Backend

- **Java 21**
- **Spring Boot**
- **Spring Security**
- **Spring Data JPA**
- **Hibernate**
- **Maven**

### 🗄️ Banco de Dados

- **PostgreSQL**
- **Modelagem relacional**
- **Índices**
- **Transactions**
- **SQL Tuning**
- **Query Optimization**
- **EXPLAIN**
- **Connection Pooling**

### 🧪 Testes

- **JUnit**
- **Mockito**
- **Testes Unitários**
- **Testes de Integração**
- **Testes de Controllers**
- **Testes de Use Cases**
- **Testes de Repository**

### 🔐 Segurança

- **Spring Security**
- **JWT (JSON Web Token)**
- **Access Token**
- **Refresh Token**
- **Tokens com curta expiração**
- **Argon2**
- **Password Hashing**
- **HTTPS / TLS**
- **Gerenciamento de Secrets**

### ⚡ Performance e Cache

- **Redis**
- **Cache**
- **Cache distribuído**
- **Expiração de dados**
- **Invalidação de Cache**
- **Compressão de dados**
- **HTTP/2**
- **HTTP/3**

### 📨 Mensageria e Eventos

- **Apache Kafka**
- **RabbitMQ**
- **Event-Driven Architecture**
- **Producers**
- **Consumers**
- **Topics**
- **Partitions**
- **Consumer Groups**
- **Queues**
- **Exchanges**
- **Routing Keys**
- **Processamento assíncrono**

### 📈 Escalabilidade

- **Load Balancer**
- **Escalabilidade horizontal**
- **Múltiplas instâncias da aplicação**
- **Stateless API**
- **CDN**
- **Distributed Cache**

### 🛡️ Proteção da Aplicação

- **Rate Limiting**
- **Web Application Firewall (WAF)**
- **Mitigação de DDoS**
- **Traffic Filtering**
- **Controle de tráfego**

### 🐳 Infraestrutura

- **Docker**
- **Docker Compose**
- **Containerização**
- **Ambientes isolados**
- **Configuração através de variáveis de ambiente**

---

## 🔄 Arquitetura Orientada a Eventos

O projeto também utiliza conceitos de **Event-Driven Architecture**, permitindo que determinadas operações sejam processadas de forma **assíncrona e desacoplada**.

Um exemplo de fluxo:

```text
                    ┌──► Atualizar Estoque
                    │
Criar Pedido ──► OrderCreated
                    │
                    ├──► Processar Pagamento
                    │
                    └──► Enviar Notificação
```

Para isso serão exploradas tecnologias como **Apache Kafka** e **RabbitMQ**, permitindo estudar diferentes modelos de comunicação assíncrona.

---

## 📈 Performance e Escalabilidade

A aplicação será evoluída para suportar cenários de maior carga através de técnicas como:

- **Redis** para cache
- **SQL Tuning** para otimização do banco
- **Rate Limiting** para controle de requisições
- **CDN** para distribuição de conteúdo
- **Load Balancer** para distribuição de tráfego
- **HTTP/2 e HTTP/3** para otimização da comunicação
- **Compressão de dados** para redução do tráfego

---

## 🛡️ Segurança e Resiliência

Também serão estudadas técnicas utilizadas em aplicações distribuídas para aumentar a segurança e a disponibilidade:

- **HTTPS**
- **JWT**
- **Argon2**
- **Rate Limiting**
- **WAF**
- **DDoS Mitigation**
- **Secrets Management**
- **Load Balancing**

---

## 🎯 Objetivo

O objetivo deste projeto não é apenas construir uma **API de E-Commerce**, mas utilizá-la como um **laboratório prático de Engenharia de Software**.

A aplicação será evoluída progressivamente, permitindo estudar como diferentes tecnologias podem solucionar problemas reais de:

**arquitetura → persistência → testes → segurança → performance → mensageria → escalabilidade → sistemas distribuídos.**

---

## 🚧 Status

**Em desenvolvimento**

O projeto será desenvolvido de forma incremental, começando pela implementação do **Core, entidades, Value Objects e casos de uso**, evoluindo posteriormente para **persistência, autenticação, testes, cache, mensageria, performance e escalabilidade**.
