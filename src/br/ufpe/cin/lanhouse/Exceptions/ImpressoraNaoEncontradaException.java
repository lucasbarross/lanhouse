package br.ufpe.cin.lanhouse.Exceptions;

/**
 * Created by vlma on 16/06/2017.
 */
public class ImpressoraNaoEncontradaException extends Exception {
	public ImpressoraNaoEncontradaException() {
		super("A impressora não foi encontrada");
	}
}
