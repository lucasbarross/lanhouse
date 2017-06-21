package br.ufpe.cin.lanhouse.negocios;

import br.ufpe.cin.lanhouse.basicas.Impressora;
import br.ufpe.cin.lanhouse.exceptions.ImpressoraJaCadastradaException;
import br.ufpe.cin.lanhouse.exceptions.ImpressoraNaoEncontradaException;
import br.ufpe.cin.lanhouse.exceptions.SemEspacoImpressoraException;
import br.ufpe.cin.lanhouse.interfaces.RepositorioImpressoras;
import br.ufpe.cin.lanhouse.repositorios.RepositorioArrayImpressoras;
import br.ufpe.cin.lanhouse.repositorios.RepositorioListaImpressoras;

public class CadastroImpressoras {
    private final RepositorioImpressoras impressoras;
    private final int capacidade = 30;

    public CadastroImpressoras(boolean array) {
        if(array) {
            impressoras = new RepositorioArrayImpressoras();
        } else {
            impressoras = new RepositorioListaImpressoras();
        }
    }

    public void cadastrar(Impressora i) throws SemEspacoImpressoraException, ImpressoraJaCadastradaException {
        if(impressoras.existe(i.getId())) {
            throw new ImpressoraJaCadastradaException();
        }

        if(this.impressoras.getTamanho() < capacidade) {
            this.impressoras.inserir(i);
        } else {
            throw new SemEspacoImpressoraException();
        }
    }

    public void remover(String impressora) throws ImpressoraNaoEncontradaException {
        this.impressoras.remover(impressora);
    }

    public void atualizar(Impressora i) throws ImpressoraNaoEncontradaException {
        this.impressoras.atualizar(i);
    }

    public Impressora procurar(String i) throws ImpressoraNaoEncontradaException {
        return this.impressoras.procurar(i);
    }

    public String listarImpressoras() {
        return this.impressoras.listarImpressoras();
    }

}
