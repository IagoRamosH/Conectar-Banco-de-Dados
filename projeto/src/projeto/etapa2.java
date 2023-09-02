package projeto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class etapa2 {
	public static void main(String[] args) {
	       
		String driver = "org.postgresql.Driver";
		String user = "postgres";
		String senha = "123456789";// minha senha do pgAdmin
		String url = "jdbc:postgresql://localhost:5432/postgres";

        try {
			Connection con = (Connection) DriverManager.getConnection(url, user, senha);

            Statement stmt = con.createStatement();

            // Verifique se a tabela já existe antes de criar
            String createTableSQL = "CREATE TABLE IF NOT EXISTS temperatura (id serial PRIMARY KEY, valor VARCHAR(10));";
            stmt.executeUpdate(createTableSQL);

            String csvFile = "etapa1.csv";
            String line;
            String csvSplitBy = ",";

            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(csvSplitBy);
                    String valor = data[0]; // Assumindo que o valor da temperatura está na primeira coluna

                    // Insira os dados na tabela
                    String insertSQL = "INSERT INTO temperatura (valor) VALUES ('" + valor + "');";
                    stmt.executeUpdate(insertSQL);
                }
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
