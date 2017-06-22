package br.ufpe.cin.lanhouse.negocios;

import br.ufpe.cin.lanhouse.basicas.Computador;
import br.ufpe.cin.lanhouse.exceptions.*;
import br.ufpe.cin.lanhouse.interfaces.RepositorioComputadores;

public class CadastroComputadores {
    private RepositorioComputadores computadores;
    private int capacidade = 100;

    public CadastroComputadores(RepositorioComputadores repositorio){
        this.computadores = repositorio;
    }

    public void cadastrar(Computador computador) throws ComputadorJaCadastradoException, SemEspacoComputadoresException{

        if(this.computadores.existe(computador.getId())) {
            throw new ComputadorJaCadastradoException(computador.getId());
        }

        if(this.computadores.getTamanho() < this.capacidade){
            this.computadores.inserir(computador);
        }else{
            throw new SemEspacoComputadoresException(computador.getId());
        }
    }

    public void remover(String nome) throws ComputadorNaoEncontradoException {
        this.computadores.remover(nome);
    }

    public void atualizar(Computador computador) throws ComputadorNaoEncontradoException {
        this.computadores.atualizar(computador);
    }

    public Computador procurar(String id) throws ComputadorNaoEncontradoException {
        return this.computadores.procurar(id);
    }

    public String listarComputadores() {
        return this.computadores.listarComputadores();
    }
}
