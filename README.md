# API Movieflix🎥

Este projeto é uma API Rest desenvolvida em Java com Spring Boot, que permite aos usuários listar gêneros de filmes, buscar filmes por ID e listar filmes com suporte a diferentes níveis de acesso de usuários. A aplicação implementa um sistema de autenticação com controle de acessos para visitantes e membros, garantindo a segurança dos dados e o acesso adequado às rotas.
Funcionalidades 📑

A API oferece os seguintes endpoints:

    GET /genres: Retorna todos os gêneros de filmes disponíveis.
    GET /movies/{id}: Retorna as informações de um filme específico.
    GET /movies: Lista todos os filmes disponíveis, com suporte a paginação e filtragem por gênero.
    POST /reviews: Permite aos membros autenticados publicar uma avaliação de um filme.

Critérios de Correção ✅

Para aprovação, a aplicação deve cumprir pelo menos 12 dos 15 critérios listados abaixo:
Endpoints e Respostas

    GET /genres
        Retorna 401 para token inválido.
        Retorna 200 com todos os gêneros para VISITOR logado.
        Retorna 200 com todos os gêneros para MEMBER logado.

    GET /movies/{id}
        Retorna 401 para token inválido.
        Retorna 200 com as informações do filme para VISITOR logado.
        Retorna 200 com as informações do filme para MEMBER logado.
        Retorna 404 se o filme com o ID fornecido não existir.

    GET /movies
        Retorna 401 para token inválido.
        Retorna 200 com uma página de filmes ordenada para VISITOR logado.
        Retorna 200 com uma página de filmes ordenada para MEMBER logado.
        Retorna 200 com uma página de filmes filtrados pelo gênero solicitado (?genreId={id}).

    POST /reviews
        Retorna 401 para token inválido.
        Retorna 403 para VISITOR logado (acesso negado).
        Retorna 201 com o objeto inserido para MEMBER logado e dados válidos.
        Retorna 422 para MEMBER logado e dados inválidos.

Competências Avaliadas 🎓

    Desenvolvimento TDD (Desenvolvimento Orientado a Testes) de uma API REST utilizando Java e Spring Boot.
    Implementação de casos de uso relacionados ao gerenciamento de filmes e gêneros.
    Consultas ao banco de dados relacional com Spring Data JPA.
    Tratamento de erros, incluindo o envio de respostas HTTP customizadas para diferentes cenários de erro.
    Controle de acesso e permissões com base no perfil do usuário para proteger as rotas da API.

Tecnologias Utilizadas 🛠️

    Java
    Spring Boot
    Spring Security
    Spring Data JPA
    Banco de Dados Relacional
    Testes Unitários e TDD

Executando o Projeto 🚀

Para iniciar o projeto, siga os passos abaixo:

    Clone o repositório: 
    git clone https://github.com/vitorlana45/Moveflix--Unit-Tests-Challenge.git

Instale as dependências e execute a aplicação:

bash

    mvn install
    mvn spring-boot:run
