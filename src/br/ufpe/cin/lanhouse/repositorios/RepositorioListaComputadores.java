package br.ufpe.cin.lanhouse.repositorios;

import br.ufpe.cin.lanhouse.basicas.Computador;
import br.ufpe.cin.lanhouse.interfaces.RepositorioComputadores;
import br.ufpe.cin.lanhouse.exceptions.*;

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
            if(this.maquina.comparar(id)){
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
    public String listarComputadores() {
        String info = "";
        if(this.maquina != null) {
            info = info + " " + this.maquina.getId() + " " + this.maquina.getEstado()+ "|" + this.maquina.getUsuario() +"\n" + this.proximo.listarComputadores();
        }
        return info;
    }

    public void atualizar(Computador maquina) throws ComputadorNaoEncontradoException {
        if(this.maquina != null){
            if(this.maquina.comparar(maquina.getId())){
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
            if(this.maquina.comparar(id)){
                this.maquina = this.proximo.maquina;
                this.proximo = this.proximo.proximo;
            } else {
                this.proximo.remover(id);
            }
        } else {
            throw new ComputadorNaoEncontradoException();
        }
    }

    public boolean existe(String id){
        boolean resposta = false;
        if(this.maquina != null){
            if(this.maquina.comparar(id)){
                resposta = true;
            } else {
                this.proximo.existe(id);
            }
        }
        return resposta;
    }
    public int getTamanho() {
        int tamanho = 0;
        if (this.proximo != null) {
            tamanho = 1 + this.proximo.getTamanho();
        }
        return tamanho;
    }
}
