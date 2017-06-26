package br.ufpe.cin.lanhouse.exceptions;

public class SemComputadorException extends Exception {

    public SemComputadorException(String nome, String cpf){
        super(nome + " (" + cpf + ") não está em um computador");
    }
}
