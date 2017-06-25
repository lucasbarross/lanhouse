package br.ufpe.cin.lanhouse.repositorios;
import br.ufpe.cin.lanhouse.basicas.Computador;
import br.ufpe.cin.lanhouse.exceptions.ComputadorNaoEncontradoException;
import br.ufpe.cin.lanhouse.interfaces.RepositorioComputadores;

public class RepositorioArrayComputadores implements RepositorioComputadores {
    private Computador [] computadores;
    private int index = 0;

    public RepositorioArrayComputadores(){
        this.computadores = new Computador [10];
    }

    public void inserir(Computador maquina) {
        if(this.index == this.computadores.length - 1){
        	
        	//Copia todo mundo pra um array com o dobro do tamanho
            Computador[] novaArray = new Computador[this.computadores.length * 2];
            for(int i = 0; i < this.computadores.length-1; i++){
            	novaArray[i] = this.computadores[i];
            }
            this.computadores = novaArray;
            this.inserir(maquina);
        }


        this.computadores[this.index] = maquina;
        this.index++;
    }
    
    public String listarComputadores() {
        String info ="";

        for(int i = 0; i < this.index; i++) {
            info = info + ' ' + this.computadores[i].getId() + ' ' + this.computadores[i].getEstado() + " | " + this.computadores[i].getUsuario() + '\n';
        }

        return info;
    }

    public Computador procurar(String id) throws ComputadorNaoEncontradoException{

        Computador maquina;
        int i = this.getIndice(id);
        if(i == -1){
            throw new ComputadorNaoEncontradoException(id);
        } else {
            maquina = this.computadores[i];
        }

        return maquina;
    }

    public void remover(String id) throws ComputadorNaoEncontradoException{
        int i = this.getIndice(id);
        if(i == -1){
            throw new ComputadorNaoEncontradoException(id);
        } else {
            this.index -= 1;
            this.computadores[i] = this.computadores[this.index];
            this.computadores[this.index] = null;
        }

    }

    public void atualizar(Computador maquina) throws ComputadorNaoEncontradoException{
        int i = this.getIndice(maquina.getId());
        if(i == -1){
            throw new ComputadorNaoEncontradoException(maquina.getId());
        } else {
            this.computadores[i] = maquina;
        }

    }

    private int getIndice(String id) {
        boolean procurando = true;
        int indice = -1;

        for (int i = 0; i < this.index && procurando; i++) {
            if (this.computadores[i].comparar(id)) {
                procurando = false;
                indice = i;
            }
        }
        return indice;
    }
    
    public int getTamanho() {
        return this.index;
    }

    public boolean existe(String id) {
        boolean existe = false;
        for(int i = 0; i < this.index && !existe; i++) {
            if(this.computadores[i].comparar(id)) {
                existe = true;
            }
        }
        return existe;
    }
}
