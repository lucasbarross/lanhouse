package br.ufpe.cin.lanhouse.negocios;

import br.ufpe.cin.lanhouse.basicas.Pessoa;
import br.ufpe.cin.lanhouse.exceptions.*;
import br.ufpe.cin.lanhouse.interfaces.RepositorioPessoas;

public class CadastroPessoas {
    private RepositorioPessoas pessoas;

    public CadastroPessoas(RepositorioPessoas repositorio) {
        this.pessoas = repositorio;
    }

    public void cadastrar(Pessoa pessoa) throws PessoaJaCadastradaException {
        if(this.pessoas.existe(pessoa.getCpf())) {
            throw new PessoaJaCadastradaException(pessoa.getCpf());
        }
        this.pessoas.inserir(pessoa);
    }

    public void remover(String nome) throws PessoaNaoEncontradaException {
        this.pessoas.remover(nome);
    }

    public void atualizar(Pessoa pessoa) throws PessoaNaoEncontradaException {
        this.pessoas.atualizar(pessoa);
    }

    public Pessoa procurar(String cpf) throws PessoaNaoEncontradaException {
        return this.pessoas.procurar(cpf);
    }

    public String listarPessoas() {
        return this.pessoas.listarPessoas();
    }
}
