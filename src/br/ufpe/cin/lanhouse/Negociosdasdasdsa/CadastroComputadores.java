package br.ufpe.cin.lanhouse.negocios;

import br.ufpe.cin.lanhouse.basicas.Computador;
import br.ufpe.cin.lanhouse.exceptions.ComputadorNaoEncontradoException;
import br.ufpe.cin.lanhouse.interfaces.RepositorioComputadores;
import br.ufpe.cin.lanhouse.repositorios.RepositorioArrayComputadores;
import br.ufpe.cin.lanhouse.repositorios.RepositorioListaComputadores;


public class CadastroComputadores {
    private RepositorioComputadores computadores;
    private static final int TAMANHOARRAY = 100;

    public CadastroComputadores(boolean array){
        if(array){
            computadores = new RepositorioArrayComputadores(TAMANHOARRAY);
        } else {
            computadores = new RepositorioListaComputadores();
        }
    }

    public void cadastrar(Computador computador) throws ArrayIndexOutOfBoundsException{
        if(computadores.getIndexAtual() < TAMANHOARRAY){
            computadores.inserir((Computador) computadores);
        }else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void remover(String nome) throws ComputadorNaoEncontradoException {
        computadores.remover(nome);
    }

    public void atualizar(Computador computador) throws ComputadorNaoEncontradoException {
        computadores.atualizar(computador);
    }

    public Computador procurar(String id) throws ComputadorNaoEncontradoException {
        return computadores.procurar(id);
    }
}
