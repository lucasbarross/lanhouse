package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by vlma on 21/06/2017.
 */
public class SemEspacoImpressoraException extends Exception {
    public SemEspacoImpressoraException(String id) {
        super("Não há mais espaço na lan house para instalar a impressora (" + id + ')');
    }
}
