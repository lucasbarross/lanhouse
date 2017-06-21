package br.ufpe.cin.lanhouse.negocios;

import br.ufpe.cin.lanhouse.basicas.Pessoa;
import br.ufpe.cin.lanhouse.exceptions.PessoaNaoEncontradaException;
import br.ufpe.cin.lanhouse.exceptions.SemEspacoAplicativosException;
import br.ufpe.cin.lanhouse.interfaces.RepositorioPessoas;
import br.ufpe.cin.lanhouse.repositorios.RepositorioArrayPessoas;
import br.ufpe.cin.lanhouse.repositorios.RepositorioListaPessoas;

public class CadastroPessoas {
    private RepositorioPessoas pessoas;
    private static final int TAMANHO = 100;

    public CadastroPessoas(boolean array){
        if(array){
            pessoas = new RepositorioArrayPessoas(TAMANHO);
        } else {
            pessoas = new RepositorioListaPessoas();
        }
    }
    // mudar index atual para gettamanho
    public void cadastrar(Pessoa pessoa) throws SemEspacoAplicativosException {
        if(pessoas.getTamanho() < TAMANHO){
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
