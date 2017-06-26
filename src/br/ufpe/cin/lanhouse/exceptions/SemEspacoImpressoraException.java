package br.ufpe.cin.lanhouse.exceptions;

public class SemEspacoImpressoraException extends Exception {
    public SemEspacoImpressoraException(String id) {
        super("Não há mais espaço na lan house para instalar a impressora (" + id + ')');
    }
}
