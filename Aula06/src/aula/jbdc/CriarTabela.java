package aula.jbdc;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CriarTabela extends JFrame {
	private Connection con;
	private java.sql.Statement st;

	public CriarTabela() {

		String driver = "org.postgresql.Driver";
		String user = "postgres";
		String senha = "123456789";// minha senha do pgAdmin
		String url = "jdbc:postgresql://localhost:5432/postgres";

		// mesmacoisa que foi feito na main para realizar a conexão
		try {
			Class.forName(driver);
			// conexãocom pgAdmin
			// . Ela utiliza o DriverManager para obter uma conexão com base na URL do banco
			// de dados, nome de usuário (user), e senha (senha) fornecidos.
			Connection con = (Connection) DriverManager.getConnection(url, user, senha);

			JOptionPane.showMessageDialog(this, "Banco conectado com sucesso!", "Mensagem",
					JOptionPane.WARNING_MESSAGE);
		} catch (SQLException e) {
			//EXCEÇÃO DO SQL
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Falha na conexão com o banco!\b" + "Mensagem: " +e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			//exceções genericas
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Falha na conexão com o banco!\b" + "Mensagem: " +e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
			System.exit(1);

		}
		
		String sentencaSQL = "CREATE TABLE tabela1 (codgo integer PRIMARY KEY, nome VARCHAR(50));";
	
		try {
			st = con.createStatement();
			st.executeUpdate(sentencaSQL);
			JOptionPane.showMessageDialog(this, "Tabela criada com sucesso!", "Mensagem: " , JOptionPane.WARNING_MESSAGE);
		}catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Não foi possivel criar a tabela" + "Mensagem: " +e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
			System.exit(2);
		}
		
		try {
			st.close();
			con.close();
		}catch (Exception e) {
			
		}
	}

	
}
