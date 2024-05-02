package br.com.alura.cepapi.modelos;

public class InvalidCepException extends RuntimeException {

	String message;
	
	public InvalidCepException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
	
}
