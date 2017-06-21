package br.ufpe.cin.lanhouse.interfaces;

import br.ufpe.cin.lanhouse.basicas.Aplicativo;
import br.ufpe.cin.lanhouse.exceptions.AppNaoEncontradoException;

public interface RepositorioAplicativos {
    void inserir(Aplicativo app);
    Aplicativo procurar(String nome) throws AppNaoEncontradoException;
    void atualizar(Aplicativo app) throws AppNaoEncontradoException;
    void remover(String nome) throws AppNaoEncontradoException;
    boolean existe(String app);
    String listarAplicativos();
}
