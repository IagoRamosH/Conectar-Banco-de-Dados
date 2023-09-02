package com.unifacisa.Aula04;


import java.io.FileWriter;
import java.io.IOException;


import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import com.unifacisa.*;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App 
{
	public static void main( String[] args ) throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        // Serialize
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, getPessoas());
        System.out.println(writer);
        
        

        // Deserialize
        String jsonInput = "[{\"id\":1,\"nome\":\"Lucas\"},{\"id\":2,\"nome\":\"Maria\"},{\"id\":3,\"nome\":\"Jose\"}]";
        List<Pessoa> p = mapper.readValue(jsonInput, new TypeReference<List<Pessoa>>(){});
        System.out.println("Pessoa: " + p);

        try {
			FileWriter escrito = new FileWriter("escrito.json");
			escrito.write(jsonInput);
			escrito.close();
			System.out.println("");
		} catch (Exception e) {
			// TODO: handle exception
		}
        
    }
    private static List<Pessoa> getPessoas() {

        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        Pessoa p1 = new Pessoa();
        p1.setId(1);
        p1.setNome("Lucas");
        p1.setCpf("8274758382");
        p1.setIdade("20");
        p1.setSobrenome("Borges");
        
        
        Pessoa p2 = new Pessoa();
        p2.setId(2);
        p2.setNome("Maria");
        p2.setCpf("8237653382");
        p2.setIdade("70");
        p2.setSobrenome("Marley");
        
        Pessoa p3 = new Pessoa();
        p3.setId(3);
        p3.setNome("Jose");
        p3.setCpf("82529002");
        p3.setIdade("40");
        p3.setSobrenome("Silva");
        
        pessoas.add(p1);
        pessoas.add(p2);
        pessoas.add(p3);

        return pessoas;

    }
}