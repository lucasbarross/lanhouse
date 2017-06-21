package br.ufpe.cin.lanhouse.negocios;

import br.ufpe.cin.lanhouse.basicas.Aplicativo;
import br.ufpe.cin.lanhouse.interfaces.RepositorioAplicativos;
import br.ufpe.cin.lanhouse.repositorios.*;
import br.ufpe.cin.lanhouse.exceptions.*;

public class CadastroAplicativos {
    private final int hd = 1000;
    private int hdUsado = 0;

    private final RepositorioAplicativos aplicativos;

    public CadastroAplicativos(boolean array){
        if(array){
            aplicativos = new RepositorioArrayAplicativos();
        } else {
            aplicativos = new RepositorioListaAplicativos();
        }
    }

    public void cadastrar(Aplicativo app) throws AppJaCadastradoException, SemEspacoAplicativosException {
        if(aplicativos.existe(app.getNome())) {
            throw new AppJaCadastradoException();
        }
        if(hdUsado + app.getTamanho() < hd){
            aplicativos.inserir(app);
            hdUsado+=app.getTamanho();
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

    public String listarAplicativos() {
        return this.aplicativos.listarAplicativos();
    }
}
