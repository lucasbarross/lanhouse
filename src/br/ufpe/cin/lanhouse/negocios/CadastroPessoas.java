package br.ufpe.cin.lanhouse.negocios;

import br.ufpe.cin.lanhouse.basicas.Pessoa;
import br.ufpe.cin.lanhouse.exceptions.PessoaJaCadastradaException;
import br.ufpe.cin.lanhouse.exceptions.PessoaNaoEncontradaException;
import br.ufpe.cin.lanhouse.exceptions.SemEspacoAplicativosException;
import br.ufpe.cin.lanhouse.interfaces.RepositorioPessoas;
import br.ufpe.cin.lanhouse.repositorios.RepositorioArrayPessoas;
import br.ufpe.cin.lanhouse.repositorios.RepositorioListaPessoas;

public class CadastroPessoas {
    private RepositorioPessoas pessoas;
    private final int capacidade = 100;

    public CadastroPessoas(boolean array){
        if(array){
            pessoas = new RepositorioArrayPessoas();
        } else {
            pessoas = new RepositorioListaPessoas();
        }
    }

    public void cadastrar(Pessoa pessoa) throws PessoaJaCadastradaException, SemEspacoAplicativosException {
        if(pessoas.existe(pessoa.getCpf())) {
            throw new PessoaJaCadastradaException();
        }

        if(pessoas.getTamanho() < capacidade){
            pessoas.inserir(pessoa);
        }else{
            throw new SemEspacoAplicativosException();
        }
    }

    public void remover(String nome) throws PessoaNaoEncontradaException {
        pessoas.remover(nome);
    }

    public void atualizar(Pessoa pessoa) throws PessoaNaoEncontradaException {
        pessoas.atualizar(pessoa);
    }

    public Pessoa procurar(String cpf) throws PessoaNaoEncontradaException {
        return pessoas.procurar(cpf);
    }
}
