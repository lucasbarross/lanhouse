package br.ufpe.cin.lanhouse.Interfaces;

import br.ufpe.cin.lanhouse.Basicas.Impressora;
import br.ufpe.cin.lanhouse.Exceptions.*;

public interface RepositorioImpressoras {

	public void cadastrar(Impressora impressora ) throws ImpressoraJaCadastradaException;

	public void remover(String numero) throws ImpressoraNaoEncontradaException;

	public void imprimirEmPreto(String numero, int numeroDePaginas) throws ImpressoraNaoEncontradaException,
			ImpressoraDescalibradaException, OutOfPagesException, OutOfBlackInkException;

	public void imprimirEmColorido(String numero, int numeroDePaginas) throws ImpressoraNaoEncontradaException,
			ImpressoraDescalibradaException, OutOfPagesException, OutOfCollorInkException;

	//public void scanear() throws ScannerDescalibradoException, ScannerNaoEncontradoException;

}
