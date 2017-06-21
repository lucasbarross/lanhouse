package br.ufpe.cin.lanhouse.repositorios;
import br.ufpe.cin.lanhouse.basicas.Pessoa;
import br.ufpe.cin.lanhouse.exceptions.PessoaNaoEncontradaException;
import br.ufpe.cin.lanhouse.interfaces.RepositorioPessoas;

public class RepositorioArrayPessoas implements RepositorioPessoas {
    private Pessoa [] pessoas;
    private int index;

    public RepositorioArrayPessoas(int tamanho){
        this.pessoas = new Pessoa [tamanho];
        this.index=0;
    }

    public void inserir(Pessoa pessoa){
        pessoas[index] = pessoa;
        index++;
    }

    public Pessoa procurar(String cpf) throws PessoaNaoEncontradaException{

        Pessoa pessoa;
        int i = this.getIndice(cpf);
        if(i == -1){
            throw new PessoaNaoEncontradaException();
        } else {
            pessoa = pessoas[i];
        }

        return pessoa;
    }

    public void remover(String id) throws PessoaNaoEncontradaException{
        int i = this.getIndice(id);
        if(i == -1){
            throw new PessoaNaoEncontradaException();
        } else {
            this.index = this.index - 1;
            this.pessoas[i] = this.pessoas[this.index];
            this.pessoas[this.index] = null;
        }

    }

    @Override
    public int getTamanho() {
        return index;
    }

    public void atualizar(Pessoa pessoa) throws PessoaNaoEncontradaException{
        int i = this.getIndice(pessoa.getCpf());
        if(i == -1){
            throw new PessoaNaoEncontradaException();
        } else {
            pessoas[i] = pessoa;
        }

    }

    private int getIndice(String cpf) {
        boolean achou = false;
        int indice = -1;

        for (int i = 0; i < pessoas.length && !achou; i++) {
            if (pessoas[i].getCpf().equals(cpf)) {
                achou = true;
                indice = i;
            }
        }
        return indice;
    }
}
