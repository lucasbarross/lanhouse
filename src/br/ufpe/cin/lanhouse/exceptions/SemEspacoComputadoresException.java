package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by lbam on 21/06/2017.
 */
public class SemEspacoComputadoresException extends Exception {
    public SemEspacoComputadoresException(){
        super("Não há mais espaço na lan house para computadores.");
    }
}
