package aula.jbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Fixacao {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "123456789";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            if (connection != null) {
                System.out.println("Conexão com o banco de dados PostgreSQL estabelecida com sucesso!");

                // Criação de um Statement
                Statement statement = connection.createStatement();
                // Consulta SQL para criar a tabela "Produto"
                String createTableQuery = "CREATE TABLE Produto (" +
                        "codProduto INT PRIMARY KEY," +
                        "produto VARCHAR(500) NOT NULL" +
                        ")";

                // Executar a criação da tabela
                statement.executeUpdate(createTableQuery);
                System.out.println("Tabela 'Produto' criada com sucesso!");

                
                // Consultas SQL de inserção
                String insertQuery1 = "INSERT INTO Produto(codProduto, produto) VALUES (1, 'arroz')";
                String insertQuery2 = "INSERT INTO Produto(codProduto, produto) VALUES (2, 'macarrao')";
                String insertQuery3 = "INSERT INTO Produto(codProduto, produto) VALUES (3, 'feijao')";

                // Executar as inserções
                statement.executeUpdate(insertQuery1);
                statement.executeUpdate(insertQuery2);
                statement.executeUpdate(insertQuery3);

                System.out.println("Inserções concluídas com sucesso!");

                // Fechar o Statement e a conexão
                statement.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }
}