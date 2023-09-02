package aula;

import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class main {
	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("https://pt.wikipedia.org/wiki/Drag_Race_Brasil").get();
		System.out.println(doc.getElementsByTag("p"));
		System.out.println(doc.getElementsContainingOwnText("Drag Race Brasil"));
		
		String conteudo = doc.getElementsByTag("h1").toString();
		try {
			FileWriter escritor = new FileWriter("arquivo_aula_02.txt");
			
			escritor.write(conteudo);
			escritor.close();
			System.out.println("Dedos gravados com sucesso!");
		}catch (Exception e) {
			System.err.println("Error ao escrever no arquivo");
		}
	

	}
}
