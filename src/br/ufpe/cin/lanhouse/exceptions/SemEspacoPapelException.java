package br.ufpe.cin.lanhouse.exceptions;

public class SemEspacoPapelException extends Exception{
	public SemEspacoPapelException() {
		super("Não há espaço para papel");
	}
}
