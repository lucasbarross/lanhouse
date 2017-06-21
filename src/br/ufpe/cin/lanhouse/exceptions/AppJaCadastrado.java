package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by vlma on 21/06/2017.
 */
public class AppJaCadastrado extends Exception {
    public AppJaCadastrado() {
        super("App já cadastrado.");
    }
}
