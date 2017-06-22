package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by vlma on 21/06/2017.
 */
public class AplicativoJaCadastradoException extends Exception {
    public AplicativoJaCadastradoException(String nome) {
        super("O aplicativo (" + nome + ") já foi cadastrado");
    }
}
