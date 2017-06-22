package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by lbam on 21/06/2017.
 */
public class SemComputadorException extends Exception {

    public SemComputadorException(String nome, String cpf){
        super(nome + " (" + cpf + ") não está em um computador");
    }
}
