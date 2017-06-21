package br.ufpe.cin.lanhouse.repositorios;

import br.ufpe.cin.lanhouse.basicas.Impressora;
import br.ufpe.cin.lanhouse.exceptions.ImpressoraJaCadastradaException;
import br.ufpe.cin.lanhouse.exceptions.ImpressoraNaoEncontradaException;
import br.ufpe.cin.lanhouse.interfaces.RepositorioImpressoras;

public class RepositorioArrayImpressoras implements RepositorioImpressoras {
	private Impressora[] impressoras;
	private int index;

	public RepositorioArrayImpressoras(int tamanho) {
		this.impressoras = new Impressora[tamanho];
		this.index = 0;
	}

	public void inserir(Impressora impressora) throws ImpressoraJaCadastradaException {
		boolean existe = false;
		for (int i = 0; i < this.getIndex(); i++) {
			if (this.impressoras[i].getNumero().equals(impressora.getNumero())) {
				existe = true;
			}
		}
		if(!existe) {
			this.impressoras[index] = impressora;
		} else {
			throw new ImpressoraJaCadastradaException();
		}
	}

	public void remover(String numero) throws ImpressoraNaoEncontradaException {
		int i = getIndexProcurado(numero);
		if (i == this.index) {
			throw new ImpressoraNaoEncontradaException();
		} else {
			this.index = this.index - 1;
			this.impressoras[i] = impressoras[this.index];
			this.impressoras[this.index] = null;
		}
	}

	public void atualizar(Impressora atualizada) throws ImpressoraNaoEncontradaException {
		int i = this.getIndexProcurado(atualizada.getNumero());
		if(i == this.index) {
			throw new ImpressoraNaoEncontradaException();
		} else {
			this.impressoras[i] = atualizada;
		}
	}



	public Impressora procurar(String numero) throws ImpressoraNaoEncontradaException {
		Impressora resposta;
		int i = this.getIndexProcurado(numero);
		if (i < this.getIndex()) {
			resposta = this.impressoras[i];
		} else {
			throw new ImpressoraNaoEncontradaException();
		}

		return resposta;
	}


	public int getIndexProcurado(String numero) {
		int indice = 0;
		for (int i = 0; i < this.getIndex(); i++) {
			if (this.impressoras[indice].getNumero().equals(numero)) {
				return indice;
			} else {
				indice++;
			}
		}
		return indice;
	}

	public int getTamanho() {
		return this.index;
	}

	public Impressora[] getImpressoras() {
		return impressoras;
	}

	public void setImpressoras(Impressora[] impressoras) {
		this.impressoras = impressoras;
	}

	public int getIndex() {
		return this.index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
