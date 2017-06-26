package br.ufpe.cin.lanhouse.exceptions;

public class ComputadorNaoEncontradoException extends Exception {
    public ComputadorNaoEncontradoException(String id) {
        super("O computador (" + id + ") não foi encontrado");
    }

}
