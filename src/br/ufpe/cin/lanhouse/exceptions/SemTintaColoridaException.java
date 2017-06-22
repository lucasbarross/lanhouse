package br.ufpe.cin.lanhouse.exceptions;

public class SemTintaColoridaException extends Exception {
	public SemTintaColoridaException(String id) {
		super("Carga de tinta colorida insuficiente na impressora (" + id + ')');
	}

}
