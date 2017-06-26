package br.ufpe.cin.lanhouse.exceptions;

public class ClienteComComputadorException extends Exception {
    public ClienteComComputadorException(String nome, String cpf) { super(nome + " (" + cpf + ") já está utilizando um computador");}
}
