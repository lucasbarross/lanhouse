package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by lbam on 21/06/2017.
 */
public class SemComputadorException extends Exception {

    public SemComputadorException(){
        super("Você não está alocado a nenhum computador.");
    }
}