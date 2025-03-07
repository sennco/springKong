# API Spring Boot

Este repositório contém uma API desenvolvida em Spring Boot.

## Tecnologias Utilizadas

- Java 17+
- Spring Boot 3+
- Banco de Dados H2 (em memória)
- Maven

## Como Rodar a Aplicação

1. Clone o repositório:

   ```sh
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```

2. Compile e execute a aplicação usando Maven:

   ```sh
   mvn spring-boot:run
   ```

## Acessando o Console do Banco H2

O H2 Database está configurado para rodar em memória. Para acessar o console:

1. Certifique-se de que a aplicação está rodando.
2. Acesse o seguinte URL no navegador:
   ```
   http://localhost:8080/h2-console
   ```
3. Use as seguintes credenciais:
   - **JDBC URL**: `jdbc:h2:mem:testdb`
   - **Usuário**: `sa`
   - **Senha**: `sa`

## Configuração do Banco H2

No arquivo `src/main/resources/application.properties`, a configuração padrão do H2 é:

```properties
spring.application.name=spring-api
spring.datasource.url=jdbc:h2:mem:apikong
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=sa
spring.jpa.database.platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
```

## Endpoints Disponíveis

Documentação dos endpoints:
```
POST /api/v1/autor
POST /api/v1/autor/{numero}/livro
GET /api/v1/autor/{numero}
GET /api/v1/autor/
GET /api/v1/autor/{numero}/livro/
```

## Rota no Postman via Kong

Na **collection** do **Postman**, dentro da pasta **"Kong"**, existe uma requisição **GET** para:

```
http://localhost:8000/api/v1/autor/12
```

Essa requisição retorna os dados do autor **sem o campo `id`**.

Para autenticação, utilize o cabeçalho:

```
Key: apikey
Value: SUA_CHAVE_GERADA
```

---

