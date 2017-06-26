package br.ufpe.cin.lanhouse.exceptions;

public class SemClienteException extends Exception {
    public SemClienteException(String id) { super("o computador (" + id + ") não está sendo utilizado"); }
}
