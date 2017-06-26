package br.ufpe.cin.lanhouse.negocios;

import br.ufpe.cin.lanhouse.basicas.Impressora;
import br.ufpe.cin.lanhouse.exceptions.*;
import br.ufpe.cin.lanhouse.interfaces.RepositorioImpressoras;

public class CadastroImpressoras {
    private RepositorioImpressoras impressoras;
    private int capacidade = 10;

    public CadastroImpressoras(RepositorioImpressoras repositorio) {
        this.impressoras = repositorio;
    }

    public void cadastrar(Impressora impressora) throws SemEspacoImpressoraException, ImpressoraJaCadastradaException {
        if(this.impressoras.existe(impressora.getId())) {
            throw new ImpressoraJaCadastradaException(impressora.getId());
        }

        if(this.impressoras.getTamanho() < this.capacidade) {
            this.impressoras.inserir(impressora);
        } else {
            throw new SemEspacoImpressoraException(impressora.getId());
        }
    }

    public void remover(String impressora) throws ImpressoraNaoEncontradaException {
        this.impressoras.remover(impressora);
    }

    public void atualizar(Impressora impressora) throws ImpressoraNaoEncontradaException {
        this.impressoras.atualizar(impressora);
    }

    public Impressora procurar(String id) throws ImpressoraNaoEncontradaException {
        return this.impressoras.procurar(id);
    }

    public String listarImpressoras() {
        return this.impressoras.listarImpressoras();
    }

}
