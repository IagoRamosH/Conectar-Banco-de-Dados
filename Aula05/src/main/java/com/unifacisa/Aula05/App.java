package com.unifacisa.Aula05;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JsonGenerationException, JsonMappingException, IOException
    {
    	//uma classe da biblioteca Jackson usada para converter objetos Java em JSON e vice-versa.
    	ObjectMapper mapper = new ObjectMapper();
    	//Serialização
    	//Cria uma instância de StringWriter, que é uma classe que permite escrever strings em memória.
    	StringWriter writer = new StringWriter();
    	/*ealiza a serialização de objetos Java em JSON. A função writeValue() 
    	 * do ObjectMapper recebe dois argumentos: o primeiro é o objeto onde
    	 *  você deseja escrever o JSON (no caso, writer), e o segundo é o objeto que você deseja serializar 
    	 *  em JSON. O objeto que está sendo serializado é retornado pela função getPessoas()
    	 * */
    	mapper.writeValue(writer, getPessoas());
    	
    	System.out.println(writer);
    	
    	//deserialização
    	/*A função readValue() do ObjectMapper é usada para fazer a 
    	 * desserialização. O primeiro argumento é a string JSON que 
    	 * você deseja desserializar (jsonInput), e o segundo argumento 
    	 * é uma instância de TypeReference que ajuda a preservar o tipo genérico da lista.
    	 *  No final dessa linha, a lista de objetos Pessoa desserializada
    	 *   é armazenada na variável p.
    	 **/
    	String jsonInput = "[{\"id\":1,\"nome\":\"Lucas\"},{\"id\":2,\"nome\":\"Maria\"},{\"id\":3,\"nome\":\"Jose\"}]";
    	List<Pessoa> p = mapper.readValue(jsonInput, new TypeReference<List<Pessoa>>(){});
        System.out.println("Pessoa: " + p.toString());
        
        

        // Cria um FileWriter para escrever no arquivo "arquivo.json"
        try (FileWriter fileWriter = new FileWriter("arquivo.json")) {
            // Escreve o conteúdo da StringWriter no arquivo
            fileWriter.write(writer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Dados salvos em arquivo.json");
    }
    
    //Criar uma lista de pessoas para adcionar ao bd
    private static List<Pessoa> getPessoas() {
    	List<Pessoa> pessoas = new ArrayList<Pessoa>();
    	Pessoa p1 = new Pessoa();
    	p1.setId(1L);
    	p1.setNome("Lucas");
    	p1.setSobrenome("Sousa");
    	p1.setIdade(20);
    	p1.setNacionalidade("Brasileiro");
    	p1.setGenero('M');
    	Pessoa p2 = new Pessoa();
    	p2.setId(2L);
    	p2.setNome("Carlos");
    	p1.setSobrenome("Leite");
    	p1.setIdade(25);
    	p1.setNacionalidade("Argentino");
    	p1.setGenero('M');		
    	Pessoa p3 = new Pessoa();
    	p3.setId(1L);
    	p3.setNome("Maria");
    	p1.setSobrenome("Sousa");
    	p1.setIdade(20);
    	p1.setNacionalidade("Brasileiro");
    	p1.setGenero('F');
    	pessoas.addAll(Arrays.asList(p1,p2,p3));
    	return pessoas;
    }
}
