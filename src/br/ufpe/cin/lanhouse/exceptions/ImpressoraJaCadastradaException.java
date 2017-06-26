package br.ufpe.cin.lanhouse.exceptions;

public class ImpressoraJaCadastradaException extends Exception {
	public ImpressoraJaCadastradaException(String id) {
		super("A impressora " + id + " já foi cadastrada");
	}
}
