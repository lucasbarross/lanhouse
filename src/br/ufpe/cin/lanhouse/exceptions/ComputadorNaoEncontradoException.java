package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by sgfl on 19/06/2017.
 */
public class ComputadorNaoEncontradoException extends Exception {
    public ComputadorNaoEncontradoException(String id) {
        super("O computador (" + id + ") não foi encontrado");
    }

}
