package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by vlma on 16/06/2017.
 */
public class ImpressoraDescalibradaException extends Exception {
	public ImpressoraDescalibradaException() {
		super("A impressora está descalibrada");
	}
}