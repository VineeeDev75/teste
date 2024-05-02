package br.com.alura.cepapi.main;

import java.io.IOException;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.alura.cepapi.controle.ControladorApi;
import br.com.alura.cepapi.modelos.ConexaoApi;
import br.com.alura.cepapi.modelos.Endereco;
import br.com.alura.cepapi.modelos.InvalidCepException;

public class Principal {

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner leitor = new Scanner(System.in);
		System.out.println("Insira seu CEP");
		String cep = leitor.nextLine();
		try {
		ConexaoApi conexao = new ConexaoApi(cep);
		
		ControladorApi controller = new ControladorApi();
		System.out.println(conexao.getResponse());
		controller.digitarArquivo(conexao);
		
		} catch(InvalidCepException e) {
			System.out.println(e.getMessage());
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

}
