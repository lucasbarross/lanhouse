package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by vlma on 16/06/2017.
 */
public class SemTintaPretaException extends Exception{
	public SemTintaPretaException(String id) {
		super("Carga de tinta preta insuficiente na impressora (" + id + ')');
	}
}
