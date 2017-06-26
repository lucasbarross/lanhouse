package br.ufpe.cin.lanhouse.exceptions;

public class AplicativoNaoEncontradoException extends Exception {
    public AplicativoNaoEncontradoException(String nome){
        super("Aplicativo (" + nome + ") não foi encontrado");
    }
}
