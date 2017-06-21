package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by sgfl on 21/06/2017.
 */
public class AplicativoJaCadastradoException extends Exception {
    public AplicativoJaCadastradoException(){
        super ("Este aplicativo já está cadastrado");
    }
}
