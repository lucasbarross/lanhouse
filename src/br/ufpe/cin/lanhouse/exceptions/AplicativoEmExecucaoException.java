package br.ufpe.cin.lanhouse.exceptions;

public class AplicativoEmExecucaoException extends Exception{
    public AplicativoEmExecucaoException(String nome){
        super("O aplicativo (" + nome + ") já está sendo executado");
    }
}
