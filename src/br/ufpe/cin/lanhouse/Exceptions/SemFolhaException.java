package br.ufpe.cin.lanhouse.Exceptions;

/**
 * Created by vlma on 16/06/2017.
 */
public class SemFolhaException extends Exception{
	public SemFolhaException() {
		super("Não tem mais folhas");
	}
}
