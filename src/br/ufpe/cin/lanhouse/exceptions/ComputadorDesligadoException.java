package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by gap on 21/06/2017.
 */

public class ComputadorDesligadoException extends Exception {
    public ComputadorDesligadoException(String id) {
        super("O computador (" + id + ") está desligado");
    }
}
