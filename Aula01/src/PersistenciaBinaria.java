import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PersistenciaBinaria {
	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa("João", 30);
		try {
			FileOutputStream arquivo = new FileOutputStream("dados.bin");
			ObjectOutputStream escritor = new ObjectOutputStream(arquivo);
			
			escritor.writeObject(pessoa);
			escritor.close();
			arquivo.close();
			System.out.println("Objeto gravado com sucesso!");
		}catch (IOException e) {
			System.err.println("Erro ao gravar objeto: ");
		}
		
	}
}
