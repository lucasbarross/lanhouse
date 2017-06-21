package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by vlma on 21/06/2017.
 */
public class PessoaJaCadastradaException extends Exception {
    public PessoaJaCadastradaException() {
        super("Pessoa já está cadastrada.");
    }
}
