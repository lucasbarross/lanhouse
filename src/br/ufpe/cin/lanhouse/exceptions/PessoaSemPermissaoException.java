package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by sgfl on 21/06/2017.
 */
public class PessoaSemPermissaoException extends Exception{
    public PessoaSemPermissaoException(String nome, String cpf){
        super(nome + " (" + cpf + ") não tem permissão para realizar esta operação");
    }
}
