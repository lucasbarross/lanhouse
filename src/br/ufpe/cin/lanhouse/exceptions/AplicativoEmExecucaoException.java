package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by sgfl on 21/06/2017.
 */
public class AplicativoEmExecucaoException extends Exception{
    public AplicativoEmExecucaoException(String nome){
        super("O aplicativo (" + nome + ") já está sendo executado");
    }
}
