package br.ufpe.cin.lanhouse.repositorios;

import br.ufpe.cin.lanhouse.basicas.Impressora;
import br.ufpe.cin.lanhouse.exceptions.ImpressoraNaoEncontradaException;
import br.ufpe.cin.lanhouse.interfaces.RepositorioImpressoras;

public class RepositorioListaImpressoras implements RepositorioImpressoras {
    private Impressora impressora;
    private RepositorioListaImpressoras proximo;

    public RepositorioListaImpressoras() {
        this.impressora = null;
        this.proximo = null;
    }

    public void inserir(Impressora impressora)  {
        if(this.impressora == null) {
            this.impressora = impressora;
            this.proximo = new RepositorioListaImpressoras();
        }
    }

    public void remover(String numero) throws ImpressoraNaoEncontradaException {
    	if(this.impressora == null) {
    		throw new ImpressoraNaoEncontradaException();
    	} else {
    		if(this.impressora.comparar(numero)) {
    			this.impressora = this.proximo.impressora;
    			this.proximo = this.proximo.proximo;
    		} else {
    			this.proximo.remover(numero);
    		}
    	}
    }

    public Impressora procurar(String numero) throws ImpressoraNaoEncontradaException {
        Impressora resposta = null;

        if(this.impressora != null) {
            if(this.impressora.comparar(numero)) {
                resposta = this.impressora;
            } else {
                this.proximo.procurar(numero);
            }
        } else {
            throw new ImpressoraNaoEncontradaException();
        }

        return resposta;
    }

    public void atualizar(Impressora atualizada) throws ImpressoraNaoEncontradaException{
    	if(this.impressora == null) {
    		throw new ImpressoraNaoEncontradaException();
    	} else {
    		if(this.impressora.comparar(atualizada.getId())) {
    			this.impressora = atualizada;
    		} else {
    			this.proximo.atualizar(atualizada);
    		}
    	}
    }

    public boolean existe(String numero){
        boolean resposta = false;
        if(this.impressora != null){
            if(this.impressora.comparar(numero)){
                resposta = true;
            } else {
                this.proximo.existe(numero);
            }
        }
        return resposta;
    }

    public int getTamanho() {
        int tamanho = 0;
        if (this.proximo != null) {
            tamanho = 1 + this.proximo.getTamanho();
        }
        return tamanho;
    }

    public String listarImpressoras() {
        String info = "";
        if(this.impressora != null) {
            info = info + " " + this.impressora.getMarca() + " " + this.impressora.getId()+"\n" + this.proximo.listarImpressoras();
        }
        return info;
    }


}
