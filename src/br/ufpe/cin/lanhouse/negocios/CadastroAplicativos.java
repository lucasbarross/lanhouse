package br.ufpe.cin.lanhouse.negocios;

import br.ufpe.cin.lanhouse.basicas.Aplicativo;
import br.ufpe.cin.lanhouse.exceptions.*;
import br.ufpe.cin.lanhouse.interfaces.RepositorioAplicativos;

public class CadastroAplicativos {
    private int hd = 1000;
    private int hdUsado = 0;

    private final RepositorioAplicativos aplicativos;

    public CadastroAplicativos(RepositorioAplicativos repositorio) {
        this.aplicativos = repositorio;
    }

    public void cadastrar(Aplicativo app) throws AplicativoJaCadastradoException, SemEspacoAplicativosException {
        if (this.aplicativos.existe(app.getNome())) {
            throw new AplicativoJaCadastradoException(app.getNome());
        }
        if (this.hdUsado + app.getTamanho() < this.hd) {
            this.aplicativos.inserir(app);
            this.hdUsado += app.getTamanho();
        } else {
            throw new SemEspacoAplicativosException(app.getNome());
        }
    }

    public void remover(String nome) throws AplicativoNaoEncontradoException {
    	hdUsado -= this.aplicativos.procurar(nome).getTamanho();
    	this.aplicativos.remover(nome);
    }

    public void atualizar(Aplicativo app) throws AplicativoNaoEncontradoException, SemEspacoAplicativosException {
    	Aplicativo antigo = this.aplicativos.procurar(app.getNome());
    	if((hdUsado - antigo.getTamanho()) + app.getTamanho() > hd){
    		throw new SemEspacoAplicativosException(app.getNome());
    	} else {
    		this.aplicativos.atualizar(app);
    	}
    }

    public Aplicativo procurar(String nome) throws AplicativoNaoEncontradoException {
        return this.aplicativos.procurar(nome);
    }

    public String listarAplicativos() {
        return this.aplicativos.listarAplicativos();
    }
}
