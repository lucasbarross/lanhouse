package br.ufpe.cin.lanhouse.negocios;

import br.ufpe.cin.lanhouse.basicas.Aplicativo;
import br.ufpe.cin.lanhouse.exceptions.AppNaoEncontradoException;
import br.ufpe.cin.lanhouse.interfaces.RepositorioAplicativos;
import br.ufpe.cin.lanhouse.repositorios.RepositorioArrayAplicativos;
import br.ufpe.cin.lanhouse.repositorios.RepositorioListaAplicativos;

public class CadastroAplicativos {
    private RepositorioAplicativos aplicativos;
    private static final int TAMANHO = 100;

    public CadastroAplicativos(boolean array){
        if(array){
            aplicativos = new RepositorioArrayAplicativos(TAMANHO);
        } else {
            aplicativos = new RepositorioListaAplicativos();
        }
    }

    public void cadastrar(Aplicativo app) throws ArrayIndexOutOfBoundsException{
        if(aplicativos.getIndexAtual() < TAMANHO){
            aplicativos.inserir(app);
        }else{
            throw new SemEspacoAplicativosException();
        }
    }

    public void remover(String nome) throws AppNaoEncontradoException {
        aplicativos.remover(nome);
    }

    public void atualizar(Aplicativo app) throws AppNaoEncontradoException {
        aplicativos.atualizar(app);
    }

    public Aplicativo procurar(String nome) throws AppNaoEncontradoException {
        return aplicativos.procurar(nome);
    }
}
