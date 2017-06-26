package br.ufpe.cin.lanhouse.exceptions;

public class AplicativoJaCadastradoException extends Exception {
    public AplicativoJaCadastradoException(String nome) {
        super("O aplicativo (" + nome + ") já foi cadastrado");
    }
}
