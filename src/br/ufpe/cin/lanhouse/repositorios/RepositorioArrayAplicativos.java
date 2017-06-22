package br.ufpe.cin.lanhouse.repositorios;

import br.ufpe.cin.lanhouse.basicas.Aplicativo;
import br.ufpe.cin.lanhouse.exceptions.AplicativoNaoEncontradoException;
import br.ufpe.cin.lanhouse.interfaces.RepositorioAplicativos;

public class RepositorioArrayAplicativos implements RepositorioAplicativos {
    private Aplicativo[] apps;
    private int index;

    public RepositorioArrayAplicativos (){
        this.apps = new Aplicativo[10];
        this.index = 0;
    }
    
    public String listarAplicativos() {
        String info ="";

        for(int i = 0; i < this.index; i++) {
            info = info + ' ' + this.apps[i].getNome() + ' ' + this.apps[i].getTamanho()+ '\n';
        }

        return info;
    }

    public void inserir(Aplicativo app)  {
        if(this.index == this.apps.length-1){
            Aplicativo[] novaArray = new Aplicativo[this.apps.length * 2];
            for(int i = 0; i < this.apps.length; i++){
            	novaArray[i] = this.apps[i];
            }
            this.apps = novaArray;
            this.inserir(app);
        }
        this.apps[this.index] = app;
        this.index++;
    }

    public Aplicativo procurar(String nome) throws AplicativoNaoEncontradoException {
        Aplicativo app;
        int i = this.getIndice(nome);

        if(i == -1){
            throw new AplicativoNaoEncontradoException(nome);
        } else {
            app = this.apps[i];
        }

        return app;
    }


    public void atualizar(Aplicativo app) throws AplicativoNaoEncontradoException {
        int i = this.getIndice(app.getNome());

        if(i == -1){
            throw new AplicativoNaoEncontradoException(app.getNome());
        } else {
            this.apps[i] = app;
        }
    }

    public void remover(String nome) throws AplicativoNaoEncontradoException {
        int i = this.getIndice(nome);

        if(i == -1){
            throw new AplicativoNaoEncontradoException(nome);
        } else {
            this.index -= 1;
            this.apps[i] = this.apps[this.index];
            this.apps[this.index] = null;
        }
    }

    private int getIndice(String nome) {
        boolean procurando = true;
        int indice = -1;

        for (int i = 0; i < this.index && procurando; i++) {
            if (this.apps[i].comparar(nome)) {
                procurando = false;
                indice = i;
            }
        }
        return indice;
    }

    public boolean existe(String app) {
        boolean existe = false;
        for(int i = 0; i < this.index && !existe; i++) {
            if(this.apps[i].comparar(app)) {
                existe = true;
            }
        }
        return existe;
    }
}
