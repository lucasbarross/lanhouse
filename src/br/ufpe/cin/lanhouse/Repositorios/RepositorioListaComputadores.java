package br.ufpe.cin.lanhouse.Repositorios;

import br.ufpe.cin.lanhouse.Basicas.Computador;
import br.ufpe.cin.lanhouse.Interfaces.RepositorioComputadores;
import br.ufpe.cin.lanhouse.Exceptions.*;

public class RepositorioListaComputadores implements RepositorioComputadores {

    private Computador maquina;
    private RepositorioListaComputadores proximo;

    public RepositorioListaComputadores(){
        this.maquina = null;
        this.proximo = null;
    }


    public Computador procurar(String id) throws ComputadorNaoEncontradoException {
        Computador resposta = null;

        if(this.maquina != null){
            if(this.maquina.getId().equals(id)){
                resposta = this.maquina;
            } else {
                this.proximo.procurar(id);
            }
        } else {
            throw new ComputadorNaoEncontradoException();
        }

        return resposta;
    }

    public void inserir(Computador maquina) {
        if(this.proximo != null){
            this.proximo.inserir(maquina);
        } else {
            this.maquina = maquina;
            this.proximo = new RepositorioListaComputadores();
        }

    }


    public void atualizar(Computador maquina) throws ComputadorNaoEncontradoException {
        if(this.maquina != null){
            if(this.maquina.getId().equals(maquina.getId())){
                this.maquina = maquina;
            } else {
                this.proximo.atualizar(maquina);
            }
        } else {
            throw new ComputadorNaoEncontradoException();
        }

    }


    public void remover(String id) throws ComputadorNaoEncontradoException {
        if(this.maquina != null){
            if(this.maquina.getId().equals(id)){
                this.maquina = this.proximo.maquina;
                this.proximo = this.proximo.proximo;
            } else {
                this.proximo.remover(id);
            }
        } else {
            throw new ComputadorNaoEncontradoException();
        }
    }
}
