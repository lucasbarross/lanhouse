package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by sgfl on 21/06/2017.
 */
public class ClienteJaCadastradoException extends Exception{
    public ClienteJaCadastradoException(){
        super ("Este cliente já está cadastrado");
    }
}
