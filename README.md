# Api de Teste Tinnova

A API de Teste Tinnova foi desenvolvida seguindo os princípios da arquitetura limpa, dividida em módulos que incluem: Core, UseCase, Application e Infrastructure. No módulo Infrastructure, utilizamos o framework Spring Boot para facilitar a implementação e manutenção do projeto.

## Índice

- [Recursos](#recursos)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Testando a API](#testando-a-api)
- [Documentação da API com Swagger](#documentação-da-api-com-swagger)
- [Instalação e Execução](#instalação-e-execução)

## Recursos

Este projeto inclui:

- Arquitetura Limpa dividida em módulos específicos.
- Utilização do Spring Boot no módulo Infrastructure.
- Coleção JSON para testes localizada na pasta `data` na raiz do projeto.

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- H2 Database
- Swagger para documentação da API

- ## Testando a API

Fora realizados testes unitários nas camadas: 
- Application
- Infrastructure

## Documentação da API com Swagger

Após iniciar a aplicação, você pode acessar a documentação da API através do Swagger nos seguintes endereços:

- Documentação da API: `http://localhost:8080/api-docs`
- Interface do Swagger UI: `http://localhost:8080/swagger-ui.html`


## Instalação e Execução

Instruções para instalar as dependências e executar a aplicação localmente.

```bash
# Clone o repositório
git clone https://github.com/DanielASantos-dev/test-tinnova-api-service.git

