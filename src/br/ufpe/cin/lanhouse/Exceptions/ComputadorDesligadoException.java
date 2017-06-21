package br.ufpe.cin.lanhouse.Exceptions;

/**
 * Created by gap on 21/06/2017.
 */

public class ComputadorDesligadoException extends Exception {
    public ComputadorDesligadoException() { super("O computador já está desligado")};
}
