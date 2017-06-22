package br.ufpe.cin.lanhouse.negocios;

import br.ufpe.cin.lanhouse.basicas.Aplicativo;
import br.ufpe.cin.lanhouse.interfaces.RepositorioAplicativos;
import br.ufpe.cin.lanhouse.exceptions.*;

public class CadastroAplicativos {
    private int hd = 1000;
    private int hdUsado;

    private final RepositorioAplicativos aplicativos;

    public CadastroAplicativos(RepositorioAplicativos repositorio){
        this.aplicativos = repositorio;
    }

    public void cadastrar(Aplicativo app) throws AplicativoJaCadastradoException, SemEspacoAplicativosException {
        if(this.aplicativos.existe(app.getNome())) {
            throw new AplicativoJaCadastradoException();
        }
        if(this.hdUsado + app.getTamanho() < this.hd){
            this.aplicativos.inserir(app);
            this.hdUsado +=app.getTamanho();
        }else{
            throw new SemEspacoAplicativosException();
        }
    }

    public void remover(String nome) throws AplicativoNaoEncontradoException {
        this.aplicativos.remover(nome);
    }

    public void atualizar(Aplicativo app) throws AplicativoNaoEncontradoException {
        this.aplicativos.atualizar(app);
    }

    public Aplicativo procurar(String nome) throws AplicativoNaoEncontradoException {
        return this.aplicativos.procurar(nome);
    }

    public String listarAplicativos() {
        return this.aplicativos.listarAplicativos();
    }
}
