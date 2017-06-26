package br.ufpe.cin.lanhouse.exceptions;

public class PessoaSemPermissaoException extends Exception{
    public PessoaSemPermissaoException(String nome, String cpf){
        super(nome + " (" + cpf + ") não tem permissão para realizar esta operação");
    }
}
