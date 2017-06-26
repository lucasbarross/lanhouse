package br.ufpe.cin.lanhouse.exceptions;

public class ComputadorUtilizadoException extends Exception {
    public ComputadorUtilizadoException(String id) { super("O computador (" + id + ") está sendo utilizado");}
}
