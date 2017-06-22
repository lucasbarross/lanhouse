package br.ufpe.cin.lanhouse.exceptions;

public class SemEspacoPapelException extends Exception{
	public SemEspacoPapelException(String id) {
		super("Não há espaço para papel na impressora (" + id + ')');
	}
}
