package br.ufpe.cin.lanhouse.exceptions;

public class ImpressoraNaoEncontradaException extends Exception {
	public ImpressoraNaoEncontradaException(String id) {
		super("A impressora (" + id + ") não foi encontrada");
	}
}
