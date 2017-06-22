package br.ufpe.cin.lanhouse.repositorios;
import br.ufpe.cin.lanhouse.basicas.Pessoa;
import br.ufpe.cin.lanhouse.exceptions.PessoaNaoEncontradaException;
import br.ufpe.cin.lanhouse.interfaces.RepositorioPessoas;

public class RepositorioArrayPessoas implements RepositorioPessoas {
    private Pessoa [] pessoas;
    private int index;

    public RepositorioArrayPessoas(){
        this.pessoas = new Pessoa [10];
        this.index = 0;
    }

    public void inserir(Pessoa pessoa){
        if(this.index == this.pessoas.length - 1){
            Pessoa[] novaArray = new Pessoa[this.pessoas.length * 2];
            System.arraycopy(this.pessoas, 0, novaArray, 0, novaArray.length);
            this.pessoas = novaArray;
            this.inserir(pessoa);
        }
        this.pessoas[this.index] = pessoa;
        this.index++;
    }

    public Pessoa procurar(String cpf) throws PessoaNaoEncontradaException{

        Pessoa pessoa;
        int i = this.getIndice(cpf);
        if(i == -1){
            throw new PessoaNaoEncontradaException(cpf);
        } else {
            pessoa = this.pessoas[i];
        }

        return pessoa;
    }

    public void remover(String cpf) throws PessoaNaoEncontradaException{
        int i = this.getIndice(cpf);
        if(i == -1){
            throw new PessoaNaoEncontradaException(cpf);
        } else {
            this.index -= 1;
            this.pessoas[i] = this.pessoas[this.index];
            this.pessoas[this.index] = null;
        }

    }

    public void atualizar(Pessoa pessoa) throws PessoaNaoEncontradaException{
        int i = this.getIndice(pessoa.getCpf());
        if(i == -1){
            throw new PessoaNaoEncontradaException(pessoa.getCpf());
        } else {
            this.pessoas[i] = pessoa;
        }

    }
    public String listarPessoas() {
        String info ="";

        for(int i = 0; i < this.index; i++) {
            info = info + ' ' + this.pessoas[i].getNome() + " | " + this.pessoas[i].getCpf() + " | " + this.pessoas[i].getSexo() + " | " + this.pessoas[i].getIdade()+ '\n';
        }

        return info;
    }

    private int getIndice(String cpf) {
        boolean procurando = true;
        int indice = -1;

        for (int i = 0; i < this.index && procurando; i++) {
            if (this.pessoas[i].comparar(cpf)) {
                procurando = false;
                indice = i;
            }
        }
        return indice;
    }
    public boolean existe(String cpf) {
        boolean existe = false;
        for (int i = 0; i < this.index && !existe; i++) {
            if (this.pessoas[i].comparar(cpf)) {
                existe = true;
            }
        }
        return existe;
    }
}
