import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaCsv {

    public static void main(String[] args) {
        List<String[]> linhas = new ArrayList<>();
        linhas.add(new String[]{"usuario", "senha"});
        linhas.add(new String[]{"Joao", "secreta"});

        try (FileWriter arquivo = new FileWriter("config.csv")) {
            for (String[] linha : linhas) {
                arquivo.append(String.join(",", linha));
                arquivo.append("\n");
            }
            arquivo.flush();
            System.out.println("Dados gravados com sucesso em config.csv!");
        } catch (IOException e) {
            System.err.println("Erro ao gravar os dados: " + e.getMessage());
        }
    }
}
