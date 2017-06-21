package br.ufpe.cin.lanhouse.interfaces;
import br.ufpe.cin.lanhouse.basicas.Computador;
import br.ufpe.cin.lanhouse.exceptions.*;

public interface RepositorioComputadores {
    Computador procurar(String id) throws ComputadorNaoEncontradoException;
    void inserir(Computador maquina) throws SemEspacoComputadoresException;
    void atualizar(Computador maquina) throws ComputadorNaoEncontradoException;
    void remover (String id) throws ComputadorNaoEncontradoException;
    int getIndexAtual();
}
