# Sistema de Login de Usuários - Etapa 4

Este projeto implementa um sistema básico de autenticação de usuários usando Java e MySQL. Ele inclui uma classe principal, `User`, que gerencia a conexão com o banco de dados e valida as credenciais fornecidas.

----

## 📂 Estrutura do Projeto

O repositório contém a seguinte classe:

- **User**: Responsável por estabelecer a conexão com o banco de dados e validar login e senha.

---

## 🔍 Detalhes da Classe `User`

### Objetivo
A classe `User` realiza a autenticação de usuários, verificando as informações armazenadas no banco de dados por meio de consultas SQL. Para isso, utiliza a API JDBC para gerenciar a comunicação com o banco.

### Principais Componentes

1. **Atributos**:
   - `nome`: Guarda o nome do usuário após a autenticação com sucesso.
   - `result`: Um booleano que indica se a autenticação foi válida.

2. **Métodos**:
   - `conectarBD`: Configura e estabelece a conexão com o banco de dados.
   - `verificarUsuario`: Valida as credenciais fornecidas, executando consultas no banco de dados.

---

## 📄 Informações Técnicas

### Requisitos
- **Java**: JDK 8 ou superior.
- **MySQL Driver**: É necessário o driver JDBC para integração com o banco MySQL.

### Configurações
O método `conectarBD` usa os seguintes parâmetros para se conectar ao banco:
- **Host**: `127.0.0.1`
- **Usuário**: `lopes`
- **Senha**: `123`
- **Banco de Dados**: `test`

Certifique-se de ajustar essas configurações para refletir o seu ambiente.

---

## 🛠️ Como Usar

1. Clone o repositório:
   ```bash
   git clone [https://github.com/C4rlozz/UX-CAIXA-BRANCA]
