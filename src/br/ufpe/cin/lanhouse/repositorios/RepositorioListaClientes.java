package br.ufpe.cin.lanhouse.repositorios;

import br.ufpe.cin.lanhouse.basicas.*;
import br.ufpe.cin.lanhouse.exceptions.PessoaNaoEncontradaException;

public class RepositorioListaClientes {

    private Cliente pessoa;
    private RepositorioListaClientes proximo;

    public RepositorioListaClientes(){
        this.pessoa = null;
        this.proximo = null;
    }

    public void inserir(Cliente pessoa) {
        if(this.proximo != null){
            this.proximo.inserir(pessoa);
        } else {
            this.pessoa = pessoa;
            this.proximo = new RepositorioListaClientes();
        }

    }

    public void remover(String cpf) throws PessoaNaoEncontradaException {
        if(this.pessoa != null){
            if(this.pessoa.getCpf().equals(cpf)){
                this.pessoa = this.proximo.pessoa;
                this.proximo = this.proximo.proximo;
            } else {
                this.proximo.remover(cpf);
            }
        } else {
            throw new PessoaNaoEncontradaException();
        }
    }

    public String getClientes() {
        String info = "";
        if(this.pessoa != null) {
            info = this.pessoa.getInfo() + "\n" + this.proximo.getClientes();
        }
        return info;
    }

    public void passarTempo() {
        if(this.pessoa != null) {
            this.pessoa.passarTempo();
            this.proximo.passarTempo();
        }
    }
}
