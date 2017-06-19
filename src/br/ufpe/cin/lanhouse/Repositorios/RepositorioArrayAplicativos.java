package br.ufpe.cin.lanhouse.Repositorios;

import br.ufpe.cin.lanhouse.Basicas.Aplicativo;
import br.ufpe.cin.lanhouse.Exceptions.AppNaoEncontradoException;
import br.ufpe.cin.lanhouse.Interfaces.RepositorioAplicativos;

public class RepositorioArrayAplicativos implements RepositorioAplicativos {
    private Aplicativo[] apps;
    private int index;

    public RepositorioArrayAplicativos (int tamanho){
        apps = new Aplicativo[tamanho];
        index = 0;
    }

    public void inserir(Aplicativo app) {
        apps[index] = app;
        index++;
    }


    public Aplicativo procurar(String nome) throws AppNaoEncontradoException {
        Aplicativo app;

        int i = this.getIndice(nome);
        if(i == -1){
            throw new AppNaoEncontradoException();
        } else {
            app = apps[i];
        }

        return app;
    }


    public void atualizar(Aplicativo app) throws AppNaoEncontradoException {
        int i = this.getIndice(app.getNome());
        if(i == -1){
            throw new AppNaoEncontradoException();
        } else {
            apps[i] = app;
        }
    }


    public void remover(String nome) throws AppNaoEncontradoException {
        int i = this.getIndice(nome);
        if(i == -1){
            throw new AppNaoEncontradoException();
        } else {
            this.index = this.index - 1;
            this.apps[i] = this.apps[this.index];
            this.apps[this.index] = null;
        }
    }
//
    private int getIndice(String nome) {
        boolean achou = false;
        int indice = -1;

        for (int i = 0; i < apps.length && !achou; i++) {
            if (apps[i].getNome().equals(nome)) {
                achou = true;
                indice = i;
            }
        }
        return indice;
    }
}
