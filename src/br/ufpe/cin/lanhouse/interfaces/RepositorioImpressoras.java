package br.ufpe.cin.lanhouse.interfaces;

import br.ufpe.cin.lanhouse.basicas.Impressora;
import br.ufpe.cin.lanhouse.exceptions.*;

public interface RepositorioImpressoras {

	void inserir(Impressora impressora) throws ImpressoraJaCadastradaException;

	void remover(String numero) throws ImpressoraNaoEncontradaException;

	Impressora procurar(String numero) throws ImpressoraNaoEncontradaException;

	void atualizar(Impressora atualizada) throws ImpressoraNaoEncontradaException;

	int getTamanho();

	boolean existe();

}
