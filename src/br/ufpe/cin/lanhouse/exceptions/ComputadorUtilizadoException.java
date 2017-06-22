package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by gap on 21/06/2017.
 */

public class ComputadorUtilizadoException extends Exception {
    public ComputadorUtilizadoException(String id) { super("O computador (" + id + ") está sendo utilizado");}
}
