package br.ufpe.cin.lanhouse.interfaces;

import br.ufpe.cin.lanhouse.basicas.Impressora;
import br.ufpe.cin.lanhouse.exceptions.*;

public interface RepositorioImpressoras {

	void inserir(Impressora impressora);

	void remover(String id) throws ImpressoraNaoEncontradaException;

	Impressora procurar(String id) throws ImpressoraNaoEncontradaException;

	void atualizar(Impressora atualizada) throws ImpressoraNaoEncontradaException;

	int getTamanho();

	boolean existe(String id);

	String listarImpressoras();

}
