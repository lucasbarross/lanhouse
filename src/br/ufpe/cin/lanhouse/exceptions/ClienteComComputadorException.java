package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by gap on 21/06/2017.
 */

public class ClienteComComputadorException extends Exception {
    public ClienteComComputadorException(String nome, String cpf) { super(nome + " (" + cpf + ") já está utilizando um computador");}
}
