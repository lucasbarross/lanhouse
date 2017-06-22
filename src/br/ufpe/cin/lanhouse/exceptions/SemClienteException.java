package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by gap on 21/06/2017.
 */

public class SemClienteException extends Exception {
    public SemClienteException(String id) { super("o computador (" + id + ") não está sendo utilizado"); }
}
