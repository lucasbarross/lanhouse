package br.ufpe.cin.lanhouse.repositorios;

import br.ufpe.cin.lanhouse.basicas.Impressora;
import br.ufpe.cin.lanhouse.exceptions.ImpressoraNaoEncontradaException;
import br.ufpe.cin.lanhouse.interfaces.RepositorioImpressoras;

public class RepositorioArrayImpressoras implements RepositorioImpressoras {
	private Impressora[] impressoras;
	private int index;

	public RepositorioArrayImpressoras() {
		this.impressoras = new Impressora[10];
		this.index = 0;
	}

	public void inserir(Impressora impressora)  {
		if(index == impressoras.length-1){
			Impressora[] novaArray = new Impressora[impressoras.length * 2];
			System.arraycopy(impressoras, 0, novaArray, 0, novaArray.length);
			impressoras = novaArray;
			inserir(impressora);
		}
		impressoras[index] = impressora;
		index++;
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
		int i = this.getIndexProcurado(atualizada.getId());
		if(i == this.index) {
			throw new ImpressoraNaoEncontradaException();
		} else {
			this.impressoras[i] = atualizada;
		}
	}



	public Impressora procurar(String numero) throws ImpressoraNaoEncontradaException {
		Impressora resposta;
		int i = this.getIndexProcurado(numero);
		if (i < this.index) {
			resposta = this.impressoras[i];
		} else {
			throw new ImpressoraNaoEncontradaException();
		}

		return resposta;
	}


	private int getIndexProcurado(String numero) {
		int indice = 0;
		for (int i = 0; i < this.index; i++) {
			if (this.impressoras[indice].getId().equals(numero)) {
				return indice;
			} else {
				indice++;
			}
		}
		return indice;
	}

	public boolean existe(String impressora) {
		for(int i = 0; i < this.index; i++) {
			if(this.impressoras[i].getId().equals(impressora)) {
				return true;
			}
		}
		return false;
	}

	public String listarImpressoras() {
		String info ="";

		for(int i = 0; i < this.index; i++) {
			info = info + " " + impressoras[i].getMarca() + " " + impressoras[i].getId()+"\n";
		}

		return info;
	}

	public int getTamanho() {
		return this.index;
	}

}
