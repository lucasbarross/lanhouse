package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by gap on 21/06/2017.
 */
public class PessoaNaoEncontradaException extends Exception {
    public PessoaNaoEncontradaException() {
        super("A pessoa não foi encontrada");
    }

}
