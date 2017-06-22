package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by sgfl on 21/06/2017.
 */
public class AplicativoEmExecucaoException extends Exception{
    public AplicativoEmExecucaoException(){
        super("O aplicativo já está sendo executado");
    }
}
