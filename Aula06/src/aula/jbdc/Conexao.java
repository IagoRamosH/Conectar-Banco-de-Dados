package aula.jbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static void main(String[] args) {
		String driver = "org.postgresql.Driver";
		String user = "postgres";
		String senha ="123456789";// minha senha do pgAdmin
		String url = "jdbc:postgresql://localhost:5432/postgres";
		
		//mesmacoisa que foi feito na main para realizar a conexão
		try {
			Class.forName(driver);
			//conexãocom pgAdmin
			//. Ela utiliza o DriverManager para obter uma conexão com base na URL do banco de dados, nome de usuário (user), e senha (senha) fornecidos. 
			Connection con = (Connection) DriverManager.getConnection(url,user,senha);
			
			
			System.out.println("Driver carregado com sucesso!");
		}catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
