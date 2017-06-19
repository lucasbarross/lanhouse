package br.ufpe.cin.lanhouse.Interfaces;

import br.ufpe.cin.lanhouse.Basicas.Impressora;
import br.ufpe.cin.lanhouse.Exceptions.*;

public interface RepositorioImpressoras {

	void inserir(Impressora impressora) throws ImpressoraJaCadastradaException;

	void remover(String numero) throws ImpressoraNaoEncontradaException;

	Impressora procurar(String numero) throws ImpressoraNaoEncontradaException;

	void atualizar(Impressora atualizada) throws ImpressoraNaoEncontradaException;

}
