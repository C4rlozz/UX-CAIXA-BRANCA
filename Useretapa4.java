package com.example.login;  // Especifica o pacote onde esta classe está localizada

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * A classe {@code User} é usada para autenticar usuários com base em dados armazenados
 * em um banco MySQL. Ela gerencia conexões e valida as credenciais.
 */
public class User {

    /**
     * Construtor padrão da classe {@code User}.
     * Este construtor é executado automaticamente ao criar uma instância da classe.
     */
    public User() {
        // Nenhuma configuração inicial é necessária ao instanciar esta classe.
    }

    /**
     * Método responsável por configurar e abrir uma conexão com o banco de dados MySQL.
     *
     * @return Um objeto {@code Connection} representando a conexão ativa,
     *         ou {@code null} caso a tentativa de conexão falhe.
     */
    public Connection conectarBD() {
        Connection conn = null;
        try {
            // Carrega o driver JDBC necessário para o banco MySQL.
            Class.forName("com.mysql.Driver.Manager").newInstance();
            // Configura os detalhes de acesso ao banco, como URL, usuário e senha.
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            // Tenta estabelecer a conexão com os parâmetros definidos.
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            // Caso ocorra um erro, apenas retorna null (recomenda-se tratar adequadamente).
        }
        return conn;
    }

    /**
     * Armazena o nome do usuário autenticado após a validação.
     * Inicialmente é definido como uma string vazia.
     */
    public String nome = "";

    /**
     * Indica se a autenticação do usuário foi bem-sucedida.
     * Por padrão, o valor é {@code false}, mudando para {@code true} em caso de sucesso.
     */
    public boolean result = false;

    /**
     * Método que verifica se as credenciais fornecidas correspondem a um usuário válido no banco.
     *
     * @param login O nome de usuário fornecido para autenticação.
     * @param senha A senha fornecida para autenticação.
     * @return {@code true} se as credenciais forem válidas; caso contrário, {@code false}.
     */
    public boolean verificarUsuario(String login, String senha) {
        String sql = "";  // Inicializa a string para montar a consulta SQL
        Connection conn = conectarBD();  // Obtém uma conexão ativa com o banco de dados

        // Cria uma consulta SQL para localizar um usuário com login e senha correspondentes
        sql += "select nome from usuarios ";
        sql += "where login = '" + login + "'";
        sql += " and senha = '" + senha + "';";

        try {
            // Prepara um Statement para enviar e executar a consulta SQL
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);  // Executa a consulta e armazena os resultados

            // Verifica se a consulta retornou algum registro
            if (rs.next()) {
                result = true;  // Indica que o login foi validado com sucesso
                nome = rs.getString("nome");  // Recupera o nome do usuário autenticado
            }
        } catch (Exception e) {
            // Se ocorrer um erro, ele é ignorado (tratar o erro é recomendado)
        }
        return result;  // Retorna o estado da autenticação (true ou false)
    }
}
