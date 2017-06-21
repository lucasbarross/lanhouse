package br.ufpe.cin.lanhouse.repositorios;

import br.ufpe.cin.lanhouse.basicas.Aplicativo;
import br.ufpe.cin.lanhouse.exceptions.AppNaoEncontradoException;
import br.ufpe.cin.lanhouse.interfaces.RepositorioAplicativos;

public class RepositorioListaAplicativos implements RepositorioAplicativos {

    private Aplicativo app;
    private RepositorioListaAplicativos proximo;

    public RepositorioListaAplicativos(){
        this.app = null;
        this.proximo = null;
    }


    public void inserir(Aplicativo app) {
        if(this.proximo != null){
            this.proximo.inserir(app);
        } else {
            this.app = app;
            this.proximo = new RepositorioListaAplicativos();
        }
    }


    public Aplicativo procurar(String nome) throws AppNaoEncontradoException {
        Aplicativo resposta = null;

        if(this.app != null){
            if(this.app.getNome().equals(nome)){
                resposta = this.app;
            } else {
                this.proximo.procurar(nome);
            }
        } else {
            throw new AppNaoEncontradoException();
        }

        return resposta;
    }

    public boolean existe(String nome){
        boolean resposta = false;

        if(this.app != null){
            if(this.app.getNome().equals(nome)){
                resposta = true;
            } else {
                this.proximo.existe(nome);
            }
        }

        return resposta;
    }


    public void atualizar(Aplicativo app) throws AppNaoEncontradoException {
        if(this.app != null){
            if(this.app.getNome().equals(app.getNome())){
                this.app = app;
            } else {
                this.proximo.atualizar(app);
            }
        } else {
            throw new AppNaoEncontradoException();
        }
    }

    public void remover(String nome) throws AppNaoEncontradoException {
        if(this.app != null){
            if(this.app.getNome().equals(nome)){
                this.app = this.proximo.app;
                this.proximo = this.proximo.proximo;
            } else {
                this.proximo.remover(nome);
            }
        } else {
            throw new AppNaoEncontradoException();
        }
    }

    public int getIndexAtual() {
        return 0;
    }

}
