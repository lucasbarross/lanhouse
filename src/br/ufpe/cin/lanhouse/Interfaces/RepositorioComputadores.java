package br.ufpe.cin.lanhouse.Interfaces;
import br.ufpe.cin.lanhouse.Basicas.Computador;
import br.ufpe.cin.lanhouse.Exceptions.*;

public interface RepositorioComputadores {
    Computador procurar(String id) throws ComputadorNaoEncontradoException;
    void inserir(Computador maquina);
    void atualizar(Computador maquina) throws ComputadorNaoEncontradoException;
    void remover (String id) throws ComputadorNaoEncontradoException;
    int getIndexAtual();
}
