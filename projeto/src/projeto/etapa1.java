package projeto;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class etapa1 {
	public static void main(String[] args) throws IOException {

		String urlCampinaGrande = "https://www.climatempo.com.br/previsao-do-tempo/15-dias/cidade/255/campinagrande-pb";
		String urlJoaoPessoa = "https://www.climatempo.com.br/previsao-do-tempo/cidade/256/joaopessoa-pb";

		Document doc = Jsoup.connect(urlCampinaGrande).get();
		Elements elementos = doc.select("span._margin-r-15");
		String conteudo = "";
		if (!elementos.isEmpty()) {
			conteudo = elementos.toString().replace("<span class=\"_margin-r-15\">", "").replace("</span>","");
		} else {
			System.out.println("Elemento não encontrado");
		}

		try {
			FileWriter escritor = new FileWriter("etapa1.csv");

			escritor.write(conteudo);
			escritor.close();
			System.out.println("Dedos gravados com sucesso!");
		} catch (Exception e) {
			System.err.println("Error ao escrever no arquivo");
		}
	}
}
