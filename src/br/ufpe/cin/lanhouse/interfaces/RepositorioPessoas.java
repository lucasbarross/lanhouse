package br.ufpe.cin.lanhouse.interfaces;
import br.ufpe.cin.lanhouse.basicas.Pessoa;
import br.ufpe.cin.lanhouse.exceptions.*;

public interface RepositorioPessoas {
    Pessoa procurar(String cpf) throws PessoaNaoEncontradaException;
    void inserir(Pessoa pessoa);
    void atualizar(Pessoa pessoa) throws PessoaNaoEncontradaException;
    void remover (String cpf) throws PessoaNaoEncontradaException;
    boolean existe(String cpf);
    String listarPessoas();
}
