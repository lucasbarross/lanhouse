package br.ufpe.cin.lanhouse.exceptions;

public class ComputadorLigadoException extends Exception {
    public ComputadorLigadoException(String id) {
        super ("O computador (" + id + ") já está ligado");
    }
}
