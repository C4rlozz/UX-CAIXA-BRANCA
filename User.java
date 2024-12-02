package login;  // 1. Especifica o pacote em que o código está localizado

// 2. Inclui as bibliotecas necessárias para trabalhar com banco O de dados
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {  // 3. Declara a classe User, que contém métodos e atributos relacionados ao usuário

    // 4. Método responsável por configurar e estabelecer uma conexão com o banco de dados
    public Connection conectarBD() {
        Connection conn = null;  // Declara uma variável para guardar a conexão estabelecida
        try {
            // 5. Inicializa o driver do MySQL para estabelecer a conexão
            Class.forName("com.mysql.Driver.Manager").newInstance();
            // 6. Configura a URL de conexão, incluindo as credenciais de acesso
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            // 7. Tenta estabelecer uma conexão utilizando as configurações fornecidas
            conn = DriverManager.getConnection(url);
        } catch (Exception e) { 
            // 8. Caso um erro ocorra, o bloco é ignorado (recomenda-se tratar o erro apropriadamente)
        }
        // 9. Retorna a conexão estabelecida (ou null, caso não tenha sido bem-sucedida)
        return conn;
    }

    // 10. Declara atributos para armazenar o nome do usuário e o estado da verificação de login
    public String nome = "";
    public boolean result = false;

    // 11. Método que verifica se as credenciais fornecidas (login e senha) são válidas
    public boolean verificarUsuario(String login, String senha) {
        String sql = "";  // 12. Inicializa uma variável para construir a consulta SQL
        // 13. Obtém uma conexão ativa com o banco de dados
        Connection conn = conectarBD();
        // 14. Monta a consulta SQL para buscar o nome do usuário baseado nas credenciais fornecidas
        sql += "select nome from usuarios ";
        sql += "where login = '" + login + "'";
        sql += " and senha = '" + senha + "';";

        try {
            // 15. Cria um objeto Statement para executar a consulta SQL
            Statement st = conn.createStatement();
            // 16. Executa a consulta e guarda os resultados retornados
            ResultSet rs = st.executeQuery(sql);
            // 17. Verifica se a consulta retornou algum registro
            if (rs.next()) {
                result = true;  // 18. Se um registro for encontrado, o resultado é marcado como verdadeiro
                nome = rs.getString("nome");  // 19. Armazena o nome do usuário retornado pela consulta
            }
        } catch (Exception e) {  
            // 20. Ignora erros ocorridos (é recomendável tratá-los adequadamente)
        }
        // 21. Retorna o resultado da verificação (true ou false)
        return result;  
    }
}  // 22. Finaliza a declaração da classe User
