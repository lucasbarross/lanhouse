package br.ufpe.cin.lanhouse.repositorios;

import br.ufpe.cin.lanhouse.basicas.Aplicativo;
import br.ufpe.cin.lanhouse.exceptions.AplicativoNaoEncontradoException;
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


    public Aplicativo procurar(String nome) throws AplicativoNaoEncontradoException {
        Aplicativo resposta = null;

        if(this.app != null){
            if(this.app.comparar(nome)){
                resposta = this.app;
            } else {
                this.proximo.procurar(nome);
            }
        } else {
            throw new AplicativoNaoEncontradoException(nome);
        }

        return resposta;
    }

    public boolean existe(String app){
        boolean resposta = false;
        if(this.app != null){
            if(this.app.comparar(app)){
                resposta = true;
            } else {
                this.proximo.existe(app);
            }
        }
        return resposta;
    }


    public void atualizar(Aplicativo app) throws AplicativoNaoEncontradoException {
        if(this.app != null){
            if(this.app.comparar(app.getNome())){
                this.app = app;
            } else {
                this.proximo.atualizar(app);
            }
        } else {
            throw new AplicativoNaoEncontradoException(app.getNome());
        }
    }

    public void remover(String nome) throws AplicativoNaoEncontradoException {
        if(this.app != null){
            if(this.app.comparar(nome)){
                this.app = this.proximo.app;
                this.proximo = this.proximo.proximo;
            } else {
                this.proximo.remover(nome);
            }
        } else {
            throw new AplicativoNaoEncontradoException(nome);
        }
    }

    public String listarAplicativos() {
        String info = "";
        if(this.app != null) {
            info = info + ' ' + this.app.getNome() + ' ' + this.app.getTamanho()+ '\n' + this.proximo.listarAplicativos();
        }
        return info;
    }

    public String getApps(){
        String listaApps = "";
        if(this.app != null){
            if(this.proximo.proximo != null) {
                listaApps = this.app.getNome() + ", " + this.proximo.getApps();
            } else {
                listaApps = this.app.getNome();
            }
        }
        return listaApps;
    }
}
