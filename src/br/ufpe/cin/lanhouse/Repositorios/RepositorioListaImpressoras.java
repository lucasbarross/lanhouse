package br.ufpe.cin.lanhouse.repositorios;

import br.ufpe.cin.lanhouse.basicas.Impressora;
import br.ufpe.cin.lanhouse.exceptions.ImpressoraJaCadastradaException;
import br.ufpe.cin.lanhouse.exceptions.ImpressoraNaoEncontradaException;
import br.ufpe.cin.lanhouse.interfaces.RepositorioImpressoras;

public class RepositorioListaImpressoras implements RepositorioImpressoras {
    private Impressora impressora;
    private RepositorioListaImpressoras proximo;
    private int tamanho;

    public RepositorioListaImpressoras() {
        this.impressora = null;
        this.proximo = null;
        this.tamanho = 0;
    }

    public void inserir(Impressora impressora) throws ImpressoraJaCadastradaException {
        if(this.existe(impressora.getNumero())) {
            throw new ImpressoraJaCadastradaException();
        } else {
            if(this.impressora == null) {
                this.impressora = impressora;
                this.proximo = new RepositorioListaImpressoras();
            }
        }
    }

    public void remover(String numero) throws ImpressoraNaoEncontradaException {
    	if(this.impressora == null) {
    		throw new ImpressoraNaoEncontradaException();
    	} else {
    		if(this.impressora.getNumero().equals(numero)) {
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
            if(this.impressora.getNumero().equals(numero)) {
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
    		if(this.impressora.getNumero().equals(atualizada.getNumero())) {
    			this.impressora = atualizada;
    		} else {
    			this.proximo.atualizar(atualizada);
    		}
    	}
    }

    public boolean existe(String numero) {
        boolean resposta = false;

        if(this.impressora.getNumero().equals(numero)) {
           resposta = true;
        }
        else {
            resposta = this.proximo.existe(numero);
        }
        return resposta;

    }

    public int getTamanho() {
        if(this.impressora != null) {
            this.tamanho++;
            this.proximo.getTamanho();
        }
        return this.tamanho;
    }


}
