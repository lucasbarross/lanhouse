package br.ufpe.cin.lanhouse.exceptions;

public class SemEspacoAplicativosException extends Exception {
    public SemEspacoAplicativosException(String nome) {
        super("Espaço insuficiente para instalar o aplicativo (" + nome + ')');
    }
}
