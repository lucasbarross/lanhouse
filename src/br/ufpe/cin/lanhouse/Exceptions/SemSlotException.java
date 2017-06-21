package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by vlma on 21/06/2017.
 */
public class SemSlotException extends Exception {
    public SemSlotException() {
        super("Não há slot para a impressora");
    }
}
