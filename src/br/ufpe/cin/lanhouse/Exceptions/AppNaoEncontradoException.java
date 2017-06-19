package br.ufpe.cin.lanhouse.Exceptions;

/**
 * Created by lbam on 19/06/2017.
 */
public class AppNaoEncontradoException extends Exception {
    public AppNaoEncontradoException(){
        super("Aplicativo não encontrado.");
    }
}
