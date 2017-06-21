package br.ufpe.cin.lanhouse.Exceptions;

/**
 * Created by sgfl on 21/06/2017.
 */
public class AppEmExecucaoException extends Exception{
    public AppEmExecucaoException(){
        super("O Aplicativo ja esta sendo executado");
    }
}
