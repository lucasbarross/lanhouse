package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by vlma on 21/06/2017.
 */
public class SemEspacoImpressoraException extends Exception {
    public SemEspacoImpressoraException() {
        super("Não há slot para a impressora");
    }
}