package br.ufpe.cin.lanhouse.exceptions;

public class NotEnoughRoomException extends Exception{
	public NotEnoughRoomException() {
		super("Não há espaço para papel");
	}
}
