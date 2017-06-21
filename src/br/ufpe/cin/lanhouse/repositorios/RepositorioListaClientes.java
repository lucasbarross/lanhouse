package br.ufpe.cin.lanhouse.repositorios;

import br.ufpe.cin.lanhouse.basicas.Cliente;
import br.ufpe.cin.lanhouse.basicas.Pessoa;
import br.ufpe.cin.lanhouse.exceptions.PessoaNaoEncontradaException;
import br.ufpe.cin.lanhouse.interfaces.RepositorioPessoas;

public class RepositorioListaClientes {

    private Cliente pessoa;
    private RepositorioListaClientes proximo;

    public RepositorioListaClientes(){
        this.pessoa = null;
        this.proximo = null;
    }

    public Pessoa procurar(String cpf) throws PessoaNaoEncontradaException {
        Pessoa resposta = null;

        if(this.pessoa != null){
            if(this.pessoa.getCpf().equals(cpf)){
                resposta = this.pessoa;
            } else {
                this.proximo.procurar(cpf);
            }
        } else {
            throw new PessoaNaoEncontradaException();
        }

        return resposta;
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

    public int getTamanho() {
        int tamanho = 0;
        if (this.pessoa != null) {
            tamanho = 1 + this.proximo.getTamanho();
        }
        return tamanho;
    }

    public String getClientes() {
        String info = "";
        if(this.pessoa != null) {
            info = this.pessoa.getInfo() + "\n" + this.proximo.getClientes();
        }
        return info;
    }
}
