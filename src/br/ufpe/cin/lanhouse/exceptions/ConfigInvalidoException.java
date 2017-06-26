package br.ufpe.cin.lanhouse.exceptions;

public class ConfigInvalidoException extends Exception{
    public ConfigInvalidoException(){
        super("O arquivo config.txt têm uma configuração inválida");
    }
}
