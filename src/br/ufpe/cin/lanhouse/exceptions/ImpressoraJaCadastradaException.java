package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by vlma on 16/06/2017.
 */
public class ImpressoraJaCadastradaException extends Exception {
	public ImpressoraJaCadastradaException(String id) {
		super("A impressora " + id + " já foi cadastrada");
	}
}
