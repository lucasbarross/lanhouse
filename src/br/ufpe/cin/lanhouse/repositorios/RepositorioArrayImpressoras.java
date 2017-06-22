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
		if(this.index == this.impressoras.length-1){
			Impressora[] novaArray = new Impressora[this.impressoras.length * 2];
			for(int i = 0; i < this.impressoras.length; i++){
            	novaArray[i] = this.impressoras[i];
            }
			this.impressoras = novaArray;
			this.inserir(impressora);
		}
		this.impressoras[this.index] = impressora;
		this.index++;
	}

	public void remover(String id) throws ImpressoraNaoEncontradaException {
		int i = this.getIndexProcurado(id);
		if (i == this.index) {
			throw new ImpressoraNaoEncontradaException(id);
		} else {
			this.index -= 1;
			this.impressoras[i] = this.impressoras[this.index];
			this.impressoras[this.index] = null;
		}
	}

	public void atualizar(Impressora atualizada) throws ImpressoraNaoEncontradaException {
		int i = this.getIndexProcurado(atualizada.getId());
		if(i == this.index) {
			throw new ImpressoraNaoEncontradaException(atualizada.getId());
		} else {
			this.impressoras[i] = atualizada;
		}
	}

	public Impressora procurar(String id) throws ImpressoraNaoEncontradaException {
		Impressora resposta;
		int i = this.getIndexProcurado(id);
		if (i < this.index) {
			resposta = this.impressoras[i];
		} else {
			throw new ImpressoraNaoEncontradaException(id);
		}

		return resposta;
	}

	private int getIndexProcurado(String numero) {
		int indice = 0;
		boolean procurando = true;
		for (int i = 0; i < this.index && procurando; i++) {
      		if (this.impressoras[indice].comparar(numero)) {
				procurando = false;
			} else {
				indice++;
			}
		}
		return indice;
	}

	public boolean existe(String id) {
		boolean existe = false;
		for(int i = 0; i < this.index && !existe; i++) {
			if(this.impressoras[i].comparar(id)) {
				existe = true;
			}
		}
		return existe;
	}

	public String listarImpressoras() {
		String info ="";

		for(int i = 0; i < this.index; i++) {
			info = info + ' ' + this.impressoras[i].getMarca() + ' ' + this.impressoras[i].getId()+ '\n';
		}

		return info;
	}

	public int getTamanho() {
		return this.index;
	}

}
