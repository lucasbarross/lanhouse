package br.ufpe.cin.lanhouse.Repositorios;

import br.ufpe.cin.lanhouse.Basicas.Impressora;
import br.ufpe.cin.lanhouse.Exceptions.ImpressoraDescalibradaException;
import br.ufpe.cin.lanhouse.Exceptions.ImpressoraJaCadastradaException;
import br.ufpe.cin.lanhouse.Exceptions.ImpressoraNaoEncontradaException;
import br.ufpe.cin.lanhouse.Exceptions.OutOfBlackInkException;
import br.ufpe.cin.lanhouse.Exceptions.OutOfCollorInkException;
import br.ufpe.cin.lanhouse.Exceptions.OutOfPagesException;
import br.ufpe.cin.lanhouse.Exceptions.ScannerDescalibradoException;
import br.ufpe.cin.lanhouse.Interfaces.RepositorioImpressoras;

public class RepositorioArrayImpressoras implements RepositorioImpressoras {
	private Impressora[] impressoras;
	private int index;

	public RepositorioArrayImpressoras() {
		this.impressoras = new Impressora[100];
		this.index = 0;
	}

	@Override
	public void cadastrar(Impressora impressora) {
		try {
			inserir(impressora);
		} catch (ImpressoraJaCadastradaException e) {
			System.out.println(e.getMessage());
		}
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

	@Override
	public void remover(String numero) {
		try {
		Impressora seraRemovida = this.procurar(numero);
		int i = getIndexProcurado(numero);
		impressoras[i] = impressoras[this.getIndex()];
		impressoras[this.getIndex()] = null;
		this.setIndex(this.getIndex() - 1);
		} catch(ImpressoraNaoEncontradaException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// FAZER DPS
	public void atualizar() {
		
	}
	
	@Override
	public void imprimirEmPreto(String numero, int numeroDePaginas) throws ImpressoraNaoEncontradaException,
			ImpressoraDescalibradaException, OutOfPagesException, OutOfBlackInkException {
		try {
			Impressora i = this.procurar(numero);
			i.imprimirEmPreto(numeroDePaginas);
		} catch (ImpressoraNaoEncontradaException e) {
			System.out.println(e.getMessage());
		} catch (ImpressoraDescalibradaException e) {
			System.out.println(e.getMessage());
		} catch (OutOfPagesException e) {
			System.out.println(e.getMessage());
		} catch (OutOfBlackInkException e) {
			System.out.println((e.getMessage()));
		}

	}

	@Override
	public void imprimirEmColorido(String numero, int numeroDePaginas) throws ImpressoraNaoEncontradaException,
			ImpressoraDescalibradaException, OutOfPagesException, OutOfCollorInkException {
		try {
			Impressora i = this.procurar(numero);
			i.imprimirEmColorido(numeroDePaginas);
		} catch (ImpressoraNaoEncontradaException e) {
			System.out.println(e.getMessage());
		} catch (ImpressoraDescalibradaException e) {
			System.out.println(e.getMessage());
		} catch (OutOfPagesException e) {
			System.out.println(e.getMessage());
		} catch (OutOfCollorInkException e) {
			System.out.println((e.getMessage()));
		}

	}

	/*
	 * @Override public void scanear() throws ScannerDescalibradoException {
	 * 
	 * }
	 */
	public Impressora procurar(String numero) throws ImpressoraNaoEncontradaException {
		Impressora resposta = null;
		int i = this.getIndexProcurado(numero);
		if (i < this.getIndex()) {
			resposta = impressoras[i];
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

	public Impressora[] getImpressoras() {
		return impressoras;
	}

	public void setImpressoras(Impressora[] impressoras) {
		this.impressoras = impressoras;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
