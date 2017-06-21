package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by vlma on 16/06/2017.
 */
public class SemFolhaException extends Exception{
	public SemFolhaException() {
		super("Não há folhas suficientes");
	}
}
