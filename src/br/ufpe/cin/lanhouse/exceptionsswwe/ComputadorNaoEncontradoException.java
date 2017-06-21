package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by sgfl on 19/06/2017.
 */
public class ComputadorNaoEncontradoException extends Exception {
    public ComputadorNaoEncontradoException() {
        super("O computador não foi encontrado");
    }

}
