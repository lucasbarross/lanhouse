package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by gap on 21/06/2017.
 */

public class ComputadorLigadoException extends Exception {
    public ComputadorLigadoException(String id) {
        super ("O computador (" + id + ") já está ligado");
    }
}
