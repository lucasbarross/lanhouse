package br.ufpe.cin.lanhouse.repositorios;

import br.ufpe.cin.lanhouse.basicas.Pessoa;
import br.ufpe.cin.lanhouse.exceptions.PessoaNaoEncontradaException;
import br.ufpe.cin.lanhouse.interfaces.RepositorioPessoas;

public class RepositorioListaPessoas implements RepositorioPessoas {

    private Pessoa pessoa;
    private RepositorioListaPessoas proximo;

    public RepositorioListaPessoas(){
        this.pessoa = null;
        this.proximo = null;
    }

    public Pessoa procurar(String cpf) throws PessoaNaoEncontradaException {
        Pessoa resposta = null;

        if(this.pessoa != null){
            if(this.pessoa.comparar(cpf)){
                resposta = this.pessoa;
            } else {
                this.proximo.procurar(cpf);
            }
        } else {
            throw new PessoaNaoEncontradaException(cpf);
        }

        return resposta;
    }

    public void inserir(Pessoa pessoa) {
        if(this.proximo != null){
            this.proximo.inserir(pessoa);
        } else {
            this.pessoa = pessoa;
            this.proximo = new RepositorioListaPessoas();
        }

    }


    public void atualizar(Pessoa pessoa) throws PessoaNaoEncontradaException {
        if(this.pessoa != null){
            if(this.pessoa.comparar(pessoa.getCpf())){
                this.pessoa = pessoa;
            } else {
                this.proximo.atualizar(pessoa);
            }
        } else {
            throw new PessoaNaoEncontradaException(pessoa.getCpf());
        }

    }


    public void remover(String cpf) throws PessoaNaoEncontradaException {
        if(this.pessoa != null){
            if(this.pessoa.comparar(cpf)){
                this.pessoa = this.proximo.pessoa;
                this.proximo = this.proximo.proximo;
            } else {
                this.proximo.remover(cpf);
            }
        } else {
            throw new PessoaNaoEncontradaException(cpf);
        }
    }
    public String listarPessoas() {
        String info = "";
        if(this.pessoa != null) {
            info = info + ' ' + this.pessoa.getNome() + " | " + this.pessoa.getCpf()+ " | " + this.pessoa.getSexo() + '\n' + this.proximo.listarPessoas();
        }
        return info;
    }
    public boolean existe(String cpf){
        boolean resposta = false;
        if(this.pessoa != null){
            if(this.pessoa.comparar(cpf)){
                resposta = true;
            } else {
                this.proximo.existe(cpf);
            }
        }
        return resposta;
    }

}
