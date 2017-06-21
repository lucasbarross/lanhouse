package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by sgfl on 21/06/2017.
 */
public class PessoaSemPermissaoException extends Exception{
    public PessoaSemPermissaoException(){
        super("Esta pessoa não tem permissão para realizar estas operações");
    }
}
