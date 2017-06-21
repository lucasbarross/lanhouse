package br.ufpe.cin.lanhouse.repositorios;

import br.ufpe.cin.lanhouse.basicas.Aplicativo;
import br.ufpe.cin.lanhouse.exceptions.AppNaoEncontradoException;
import br.ufpe.cin.lanhouse.exceptions.SemEspacoAplicativosException;
import br.ufpe.cin.lanhouse.interfaces.RepositorioAplicativos;

public class RepositorioArrayAplicativos implements RepositorioAplicativos {
    private Aplicativo[] apps;
    private int index;

    public RepositorioArrayAplicativos (){
        apps = new Aplicativo[10];
        index = 0;
    }
    public String listarAplicativos() {
        String info ="";

        for(int i = 0; i < this.index; i++) {
            info = info + " " + apps[i].getNome() + " " + apps[i].getTamanho()+"\n";
        }

        return info;
    }

    public void inserir(Aplicativo app)  {
        if(index == apps.length-1){
            Aplicativo[] novaArray = new Aplicativo[apps.length * 2];
            for (int i = 0; i < novaArray.length; i++) {
                novaArray[i] = apps[i];
            }
            apps = novaArray;
            inserir(app);
        }
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

    public int getTamanho(){
        return index;
    }

    public boolean existe(String app) {
        for(int i = 0; i < this.index; i++) {
            if(this.apps[i].equals(app)) {
                return true;
            }
        }
        return false;
    }
}
