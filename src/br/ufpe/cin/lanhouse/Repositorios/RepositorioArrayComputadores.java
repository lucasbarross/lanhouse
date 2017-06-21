package br.ufpe.cin.lanhouse.repositorios;
import br.ufpe.cin.lanhouse.basicas.Computador;
import br.ufpe.cin.lanhouse.exceptions.ComputadorNaoEncontradoException;
import br.ufpe.cin.lanhouse.interfaces.RepositorioComputadores;

public class RepositorioArrayComputadores implements RepositorioComputadores {
    private Computador [] computadores;
    private int index;

    public RepositorioArrayComputadores(int tamanho){
        this.computadores = new Computador [tamanho];
        this.index=0;
    }

    public void inserir(Computador maquina){
        computadores[index] = maquina;
        index++;
    }

    public Computador procurar(String id) throws ComputadorNaoEncontradoException{

        Computador maquina;
        int i = this.getIndice(id);
        if(i == -1){
            throw new ComputadorNaoEncontradoException();
        } else {
            maquina = computadores[i];
        }

        return maquina;
    }

    public void remover(String id) throws ComputadorNaoEncontradoException{
        int i = this.getIndice(id);
        if(i == -1){
            throw new ComputadorNaoEncontradoException();
        } else {
            this.index = this.index - 1;
            this.computadores[i] = this.computadores[this.index];
            this.computadores[this.index] = null;
        }

    }

    public void atualizar(Computador maquina) throws ComputadorNaoEncontradoException{
        int i = this.getIndice(maquina.getId());
        if(i == -1){
            throw new ComputadorNaoEncontradoException();
        } else {
            computadores[i] = maquina;
        }

    }

    private int getIndice(String nome) {
        boolean achou = false;
        int indice = -1;

        for (int i = 0; i < computadores.length && !achou; i++) {
            if (computadores[i].getId().equals(nome)) {
                achou = true;
                indice = i;
            }
        }
        return indice;
    }
}
