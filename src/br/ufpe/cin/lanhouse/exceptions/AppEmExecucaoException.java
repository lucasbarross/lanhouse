package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by sgfl on 21/06/2017.
 */
public class AppEmExecucaoException extends Exception{
    public AppEmExecucaoException(){
        super("O aplicativo já está sendo executado");
    }
}
