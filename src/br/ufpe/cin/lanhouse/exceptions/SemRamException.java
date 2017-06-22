package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by sgfl on 21/06/2017.
 */
public class SemRamException extends Exception {
    public SemRamException(String idComputador, String nomeApp){
        super ("Computador (" + idComputador + ") não tem ram suficiente para executar o aplicativo (" + nomeApp + ')');
    }
}
