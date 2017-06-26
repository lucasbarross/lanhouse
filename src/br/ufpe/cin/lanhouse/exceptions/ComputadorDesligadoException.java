package br.ufpe.cin.lanhouse.exceptions;

public class ComputadorDesligadoException extends Exception {
    public ComputadorDesligadoException(String id) {
        super("O computador (" + id + ") está desligado");
    }
}
