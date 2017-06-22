package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by lbam on 21/06/2017.
 */
public class SemEspacoComputadoresException extends Exception {
    public SemEspacoComputadoresException(String id){
        super("Não há mais espaço na lan house para instalar o computador (" + id + ')');
    }
}
