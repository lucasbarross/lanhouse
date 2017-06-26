package br.ufpe.cin.lanhouse.exceptions;

public class SemTintaPretaException extends Exception{
	public SemTintaPretaException(String id) {
		super("Carga de tinta preta insuficiente na impressora (" + id + ')');
	}
}
