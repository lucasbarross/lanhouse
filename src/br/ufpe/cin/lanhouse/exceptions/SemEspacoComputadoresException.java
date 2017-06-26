package br.ufpe.cin.lanhouse.exceptions;

public class SemEspacoComputadoresException extends Exception {
    public SemEspacoComputadoresException(String id){
        super("Não há mais espaço na lan house para instalar o computador (" + id + ')');
    }
}
