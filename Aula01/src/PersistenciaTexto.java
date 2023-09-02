import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;

public class PersistenciaTexto {
	public static void main(String[] args) {
		String conteudo = "Este é um exemplo de persistência em arquvio de texto";
		try {
			FileWriter escritor = new FileWriter("arquivo.txt");
			
			escritor.write(conteudo);
			escritor.close();
			System.out.println("Dedos gravados com sucesso!");
		}catch (Exception e) {
			System.err.println("Error ao escrever no arquivo");
		}
	}

}
