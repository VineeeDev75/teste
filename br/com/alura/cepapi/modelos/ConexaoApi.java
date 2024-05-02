package br.com.alura.cepapi.modelos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ConexaoApi {
	private Integer cep;
	private String endereco;
	HttpResponse<String> response;

	public ConexaoApi(String cep) throws IOException, InterruptedException {
		cep = cep.replace("-", "");

		for (int i = 0; i < cep.length(); i++) {
			if (!Character.isDigit(cep.charAt(i))) {
				throw new IllegalArgumentException("Você inseriu letras no CEP");
			}
		}
		if (cep.length() > 8 || cep.length() < 8) {
			throw new InvalidCepException("Você inseriu um CEP inválido");
		}
		this.cep = Integer.parseInt(cep);
		this.endereco = "https://viacep.com.br/ws/" + cep + "/json/";

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
		response = client.send(request, BodyHandlers.ofString());
	}
	
	public String getResponse() {
		return this.response.body();
	}
	
	public Integer getCep() {
		return this.cep;
	}
	
	public String endereco() {
		return this.endereco;
	}

}
