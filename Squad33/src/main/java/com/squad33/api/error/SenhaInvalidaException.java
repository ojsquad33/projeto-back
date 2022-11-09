package com.squad33.api.error;

public class SenhaInvalidaException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SenhaInvalidaException() {
		super("Senha Inválida!");
	}
}
