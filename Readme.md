
<div align="center">
  <img src="https://i.ibb.co/x74W8QK/Gutendex.png"/>
</div>

<h1 style="color:#bb856b">Gutendex<span style="color:#121054">Lib</span></h1>
Aplicação via console para estudo da linguagem JAVA e consumo de APIs.

A API Gutendex é um catálogo com informações sobre os mais de 70 mil livros presentes no Project Gutenberg (biblioteca online gratuita).

# Índice
1. [Descrição do Projeto](#descrição-do-projeto)
2. [Status do Projeto](#status-do-projeto)
3. [Funcionalidades e Demonstração da Aplicação](#funcionalidades-e-demonstração-da-aplicação)
4. [Acesso ao Projeto](#acesso-ao-projeto)
5. [Tecnologias Utilizadas](#tecnologias-utilizadas)
6. [Pessoas Contribuidoras](#pessoas-contribuidoras)
7. [Pessoas Desenvolvedoras do Projeto](#pessoas-desenvolvedoras-do-projeto)
8. [Licença](#licença)

## Descrição do Projeto

Este projeto é uma API desenvolvida em Java que utiliza Jackson para serialização e desserialização de dados JSON, JPA (Java Persistence API) para a persistência de dados, e PostgreSQL como banco de dados. A API consome dados de livros da API Gutedex, permitindo operações CRUD (Create, Read, Update, Delete) em um banco de dados local.

## Status do Projeto

![Badge em Desenvolvimento](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow)

## Funcionalidades e Demonstração da Aplicação

## :hammer: Funcionalidades do projeto

- `Listar Livros`: Recupera uma lista de livros da API Gutedex e salva no banco de dados.
- `Buscar Livro por ID`: Retorna os detalhes de um livro específico com base no seu ID.

### Demonstração da Aplicação

1. **Listar Livros**:

Exemplo de resposta:

```json
[
  {
    "id": 1,
    "titulo": "Livro Exemplo",
    "autor": "Autor Exemplo",
    "isbn": "1234567890",
    "publicacao": "2023-05-01"
  }
]
```

1. **Buscar Livro por ID**:

```bash
GET /api/livros/{id}
```

Exemplo de resposta:

```json
{
  "id": 1,
  "titulo": "Livro Exemplo",
  "autor": "Autor Exemplo",
  "isbn": "1234567890",
  "publicacao": "2023-05-01"
}
```

3. **Adicionar Livro**:

```bash
POST /api/livros
```

Exemplo de corpo da requisição:

```json
{
  "titulo": "Novo Livro",
  "autor": "Novo Autor",
  "isbn": "0987654321",
  "publicacao": "2024-01-01"
}
```

### 📁 Acesso ao projeto

Você pode acessar o código fonte deste projeto ou baixá-lo através do seguinte repositório do GitHub:

- [Projeto](https://github.com/AldomarAssolin/gutendexLib)

### 🛠️ Para clonar o repositório, use o seguinte comando:

```bash
git clone https://github.com/AldomarAssolin/gutendexLib
```

## Tecnologias Utilizadas

- ``Java``: Linguagem de programação utilizada.
- ``Spring Boot``: Framework para construção da API.
- ``Jackson``: Biblioteca para serialização e desserialização de dados JSON.
- ``JPA (Java Persistence API)``: API de persistência para operações de banco de dados.
- ``PostgreSQL``: Banco de dados relacional utilizado.
- ``Maven``: Ferramenta de automação de build.

## Pessoas Contribuidoras


## Pessoas Desenvolvedoras do Projeto

### Autores

| [<img loading="lazy" src="https://avatars.githubusercontent.com/u/70400399?v=4" width=115><br><sub>Aldomar Assolin</sub>](https://github.com/aldomarassolin) |
| :---: | 

## Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

<div align="center">
  <img src="https://github.com/AldomarAssolin/gutendexLib/assets/70400399/22b48a68-1cc9-4fe7-920b-f0fe431234d6" width="200"/>
</div>