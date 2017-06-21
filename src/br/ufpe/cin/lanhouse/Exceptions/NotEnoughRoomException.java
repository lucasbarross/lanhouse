package br.ufpe.cin.lanhouse.Exceptions;

public class NotEnoughRoomException extends Exception{
	public NotEnoughRoomException() {
		super("Não há espaço para papel");
	}
}
