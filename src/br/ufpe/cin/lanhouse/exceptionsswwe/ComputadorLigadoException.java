package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by gap on 21/06/2017.
 */

public class ComputadorLigadoException extends Exception {
    public ComputadorLigadoException() {
        super("O computador já está ligado");
    }
}
