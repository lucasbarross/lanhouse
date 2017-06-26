package br.ufpe.cin.lanhouse.exceptions;

public class SemFolhaException extends Exception{
	public SemFolhaException(String id) {
		super("Não há folhas suficientes na impressora (" + id + ')');
	}
}
