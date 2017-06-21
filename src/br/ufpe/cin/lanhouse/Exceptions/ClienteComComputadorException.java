package br.ufpe.cin.lanhouse.Exceptions;

/**
 * Created by gap on 21/06/2017.
 */

public class ClienteComComputadorException extends Exception {
    public ClienteComComputadorException() { super("O cliente já está utilizando um computador");}
}
