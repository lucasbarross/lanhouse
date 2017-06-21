package br.ufpe.cin.lanhouse.negocios;

import br.ufpe.cin.lanhouse.basicas.Impressora;
import br.ufpe.cin.lanhouse.exceptions.ImpressoraJaCadastradaException;
import br.ufpe.cin.lanhouse.exceptions.ImpressoraNaoEncontradaException;
import br.ufpe.cin.lanhouse.exceptions.SemSlotException;
import br.ufpe.cin.lanhouse.interfaces.RepositorioImpressoras;
import br.ufpe.cin.lanhouse.repositorios.RepositorioArrayImpressoras;
import br.ufpe.cin.lanhouse.repositorios.RepositorioListaImpressoras;

public class CadastroImpressoras {
    private RepositorioImpressoras impressoras;
    private static final int TAMANHO = 30;

    public CadastroImpressoras(boolean array) {
        if(array) {
            impressoras = new RepositorioArrayImpressoras(TAMANHO);
        } else {
            impressoras = new RepositorioListaImpressoras();
        }
    }

    public void cadastrar(Impressora i) throws SemSlotException, ImpressoraJaCadastradaException {
        if(this.impressoras.getTamanho() < TAMANHO) {
            this.impressoras.inserir(i);
        } else {
            throw new SemSlotException();
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



}
