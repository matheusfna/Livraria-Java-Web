# 📚 Livraria Java Web

> Sistema simples de gerenciamento de livros com cadastro, listagem e detalhamento de registros.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![JSP](https://img.shields.io/badge/JSP-007396?style=for-the-badge&logo=apachetomcat&logoColor=white)
![Servlets](https://img.shields.io/badge/Servlets-004085?style=for-the-badge&logo=java&logoColor=white)
![Status](https://img.shields.io/badge/status-finalizado-brightgreen?style=for-the-badge)

---

## ✨ Descrição

Projeto Java Web com estrutura **MVC** que permite:
- Cadastro de livros
- Visualização dos detalhes de cada livro
- Listagem geral dos livros cadastrados no banco de dados relacional via **JDBC**.

---

## 🛠️ Tecnologias

- Java EE (**Servlets** e **JSP**)
- **JDBC** com **DAO Pattern**
- Servidor **Tomcat**
- Banco de Dados Relacional (ex: MySQL ou PostgreSQL)
- **HTML/CSS** (Templates em JSP)

---

## 📂 Estrutura do Projeto

## 🔍 Principais Arquivos

| Arquivo                    | Descrição                                                        |
|----------------------------|------------------------------------------------------------------|
| `Livro.java`               | Entidade representando um livro                                  |
| `LivroDAO.java`            | Classe de acesso a dados para CRUD de livros via JDBC            |
| `ConnectionFactory.java`   | Criação de conexões com o banco                                  |
| `LivroController.java`     | Servlet que gerencia requisições HTTP                            |
| `cadastrar-livro.jsp`      | Página para inserir novos livros                                 |
| `mostrar-livro.jsp`        | Página que lista todos os livros                                 |
| `detalhes-livro.jsp`       | Página com detalhes de um livro específico                       |

---

## 🚀 Como executar localmente

```bash
# 1. Clone o repositório
git clone https://github.com/seu-usuario/livrariaProjeto.git

# 2. Importe o projeto em sua IDE (Eclipse, IntelliJ ou VS Code com extensões Java)
# 3. Configure o servidor Tomcat no projeto
# 4. Ajuste as configurações de banco na classe ConnectionFactory.java
# 5. Rode o projeto e acesse via navegador

