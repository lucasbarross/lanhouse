package br.ufpe.cin.lanhouse.Negocios;

import br.ufpe.cin.lanhouse.Basicas.Impressora;
import br.ufpe.cin.lanhouse.Exceptions.ImpressoraJaCadastradaException;
import br.ufpe.cin.lanhouse.Exceptions.ImpressoraNaoEncontradaException;
import br.ufpe.cin.lanhouse.Exceptions.OutOfSlotsException;
import br.ufpe.cin.lanhouse.Interfaces.RepositorioImpressoras;
import br.ufpe.cin.lanhouse.Repositorios.RepositorioArrayImpressoras;
import br.ufpe.cin.lanhouse.Repositorios.RepositorioListaImpressoras;

public class CadastroImpressoras {
    private RepositorioImpressoras impressoras;
    private static final int TAMANHOARRAY = 30;
    private boolean isArray;

    public CadastroImpressoras(boolean array) {
        if(array) {
            impressoras = new RepositorioArrayImpressoras(TAMANHOARRAY);
            //array
            isArray = true;
        } else {
            impressoras = new RepositorioListaImpressoras();
            //lista
            isArray = false;
        }
    }

    public void cadastrar(Impressora i) throws OutOfSlotsException, ImpressoraJaCadastradaException {
        if(isArray) {
            if(this.impressoras.getTamanho() < TAMANHOARRAY) {
                this.impressoras.inserir(i);
            } else {
                throw new OutOfSlotsException();
            }
        } else {
            if(this.impressoras.getTamanho() < TAMANHOARRAY) {
                this.impressoras.inserir(i);
            } else {
                throw new OutOfSlotsException();
            }
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
