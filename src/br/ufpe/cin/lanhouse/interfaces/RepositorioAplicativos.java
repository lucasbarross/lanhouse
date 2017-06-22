package br.ufpe.cin.lanhouse.interfaces;

import br.ufpe.cin.lanhouse.basicas.Aplicativo;
import br.ufpe.cin.lanhouse.exceptions.AplicativoNaoEncontradoException;

public interface RepositorioAplicativos {
    void inserir(Aplicativo app);
    Aplicativo procurar(String nome) throws AplicativoNaoEncontradoException;
    void atualizar(Aplicativo app) throws AplicativoNaoEncontradoException;
    void remover(String nome) throws AplicativoNaoEncontradoException;
    boolean existe(String app);
    String listarAplicativos();
}
