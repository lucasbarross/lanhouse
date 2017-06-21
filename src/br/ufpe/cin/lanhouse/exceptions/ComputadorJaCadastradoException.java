package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by sgfl on 21/06/2017.
 */
public class ComputadorJaCadastradoException extends Exception {
    public ComputadorJaCadastradoException(){
        super ("Este computador já está cadastrado");
    }
}
