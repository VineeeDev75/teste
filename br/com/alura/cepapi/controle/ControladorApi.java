package br.com.alura.cepapi.controle;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.alura.cepapi.modelos.ConexaoApi;
import br.com.alura.cepapi.modelos.Endereco;

public class ControladorApi {
	
	
	public String getJson(ConexaoApi c) {
		return c.getResponse();
	}
	
	
	public String digitarArquivo(ConexaoApi c) throws IOException {
		FileWriter escrita = new FileWriter("cep.json");
		escrita.write(c.getResponse());
		escrita.close();
		return "Arquivo digitado com sucesso.";
	}

}
