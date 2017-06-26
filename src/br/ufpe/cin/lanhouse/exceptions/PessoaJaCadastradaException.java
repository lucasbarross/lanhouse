package br.ufpe.cin.lanhouse.exceptions;

public class PessoaJaCadastradaException extends Exception {
    public PessoaJaCadastradaException(String cpf) {
        super("O cpf: (" + cpf + ") já foi cadastrado");
    }
}
