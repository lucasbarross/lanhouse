package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by gap on 21/06/2017.
 */
public class ConfigInvalidoException extends Exception{
    public ConfigInvalidoException(){
        super("O arquivo config.txt têm uma configuração inválida");
    }
}
