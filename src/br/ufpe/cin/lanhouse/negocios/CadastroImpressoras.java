package br.ufpe.cin.lanhouse.negocios;

import br.ufpe.cin.lanhouse.basicas.Impressora;
import br.ufpe.cin.lanhouse.exceptions.*;
import br.ufpe.cin.lanhouse.interfaces.RepositorioImpressoras;

public class CadastroImpressoras {
    private RepositorioImpressoras impressoras;
    private int capacidade = 30;

    public CadastroImpressoras(RepositorioImpressoras repositorio) {
        this.impressoras = repositorio;
    }

    public void cadastrar(Impressora i) throws SemEspacoImpressoraException, ImpressoraJaCadastradaException {
        if(this.impressoras.existe(i.getId())) {
            throw new ImpressoraJaCadastradaException();
        }

        if(this.impressoras.getTamanho() < this.capacidade) {
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
