package br.ufpe.cin.lanhouse.Interfaces;

import br.ufpe.cin.lanhouse.Basicas.Aplicativo;
import br.ufpe.cin.lanhouse.Exceptions.AppNaoEncontradoException;

public interface RepositorioAplicativos {
    void inserir(Aplicativo app);
    Aplicativo procurar(String nome) throws AppNaoEncontradoException;
    void atualizar(Aplicativo app) throws AppNaoEncontradoException;
    void remover(String nome) throws AppNaoEncontradoException;
}
