package br.ufpe.cin.lanhouse.exceptions;

public class PessoaNaoEncontradaException extends Exception {
    public PessoaNaoEncontradaException(String cpf) {
        super("O cpf: (" + cpf +  ") não foi encontrado");
    }

}
