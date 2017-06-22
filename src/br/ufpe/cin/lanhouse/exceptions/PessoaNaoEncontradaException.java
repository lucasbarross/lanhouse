package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by gap on 21/06/2017.
 */
public class PessoaNaoEncontradaException extends Exception {
    public PessoaNaoEncontradaException(String cpf) {
        super("O cpf: (" + cpf +  ") não foi encontrado");
    }

}
