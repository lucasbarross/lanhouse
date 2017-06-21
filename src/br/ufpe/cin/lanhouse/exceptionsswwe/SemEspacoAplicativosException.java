package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by gap on 21/06/2017.
 */

public class SemEspacoAplicativosException extends Exception {
    public SemEspacoAplicativosException() {
        super("Espaço insuficiente para instalar aplicativo.");
    }
}
