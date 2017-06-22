package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by lbam on 19/06/2017.
 */
public class AplicativoNaoEncontradoException extends Exception {
    public AplicativoNaoEncontradoException(String nome){
        super("Aplicativo (" + nome + ") não foi encontrado");
    }
}
