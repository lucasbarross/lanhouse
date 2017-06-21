package br.ufpe.cin.lanhouse.Exceptions;

public class NotEnoughRoomException extends Exception{
	public NotEnoughRoomException() {
		super("Sem espaço para o papel");
	}
}
