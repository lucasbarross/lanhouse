package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by vlma on 21/06/2017.
 */
public class AppJaCadastradoException extends Exception {
    public AppJaCadastradoException() {
        super("App já cadastrado.");
    }
}
