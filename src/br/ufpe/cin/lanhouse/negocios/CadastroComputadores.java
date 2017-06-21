package br.ufpe.cin.lanhouse.negocios;

import br.ufpe.cin.lanhouse.basicas.Computador;
import br.ufpe.cin.lanhouse.exceptions.ComputadorJaCadastradoException;
import br.ufpe.cin.lanhouse.exceptions.ComputadorNaoEncontradoException;
import br.ufpe.cin.lanhouse.exceptions.SemEspacoComputadoresException;
import br.ufpe.cin.lanhouse.interfaces.RepositorioComputadores;
import br.ufpe.cin.lanhouse.repositorios.*;


public class CadastroComputadores {
    private final RepositorioComputadores computadores;
    private final int capacidade = 100;

    public CadastroComputadores(boolean array){
        if(array){
            computadores = new RepositorioArrayComputadores();
        } else {
            computadores = new RepositorioListaComputadores();
        }
    }

    public void cadastrar(Computador computador) throws ComputadorJaCadastradoException, SemEspacoComputadoresException{

        if(computadores.existe(computador.getId())) {
            throw new ComputadorJaCadastradoException();
        }

        if(computadores.getTamanho() < capacidade){
            computadores.inserir((Computador) computadores);
        }else{
            throw new SemEspacoComputadoresException();
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

    public String listarComputadores() {
        return this.computadores.listarComputadores();
    }
}
