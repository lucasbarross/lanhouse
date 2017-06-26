package br.ufpe.cin.lanhouse.exceptions;

public class ComputadorJaCadastradoException extends Exception {
    public ComputadorJaCadastradoException(String id){
        super ("O computador (" + id + ") já está cadastrado");
    }
}
