package br.com.fiap.exception;

public class CommitException extends Exception {

	public CommitException() {
		super("Erro commit");
	}
	
	public CommitException(String message) {
		super(message);
	}
	
}