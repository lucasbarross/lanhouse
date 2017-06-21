package br.ufpe.cin.lanhouse.programa;

import br.ufpe.cin.lanhouse.basicas.*;
import br.ufpe.cin.lanhouse.exceptions.*;
import br.ufpe.cin.lanhouse.fachada.*;
import br.ufpe.cin.lanhouse.negocios.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LanHouse {

	public static void main(String[] args) {
		Administrador adm;
		try {
			FileReader entrada;
			entrada = new FileReader("config.txt");
			BufferedReader br = new BufferedReader(entrada);
			String linha;
			linha = br.readLine();
			boolean array;
			array = linha.equals("array");
			adm = new Administrador(new CadastroAplicativos(array), new CadastroComputadores(array), new CadastroImpressoras(array), new CadastroPessoas(array));
		} catch (IOException e) {
			e.printStackTrace();
		}
/*
		try {
			adm.cadastrarComputador(new Computador("1", 500));
			adm.cadastrarComputador(new Computador("2", 500));
			adm.cadastrarComputador(new Computador("3", 500));
			adm.cadastrarComputador(new Computador("4", 500));
			adm.cadastrarComputador(new Computador("5", 500));
			adm.cadastrarComputador(new Computador("6", 500));
			adm.cadastrarComputador(new Computador("7", 500));
			adm.cadastrarComputador(new Computador("8", 500));
			adm.cadastrarComputador(new Computador("9", 500));
			adm.cadastrarComputador(new Computador("10", 500));
			//erro
			adm.cadastrarComputador(new Computador("11", 500));
		} catch (ComputadorJaCadastradoException e) {
			e.printStackTrace();
		}
		try {
			adm.cadastrarPessoa(new Cliente("Joao", "1", m, 54));
			adm.cadastrarPessoa(new Cliente("Maria", "2", f, 54));
			adm.cadastrarPessoa(new Cliente("Pedro", "3", m, 54));
			adm.cadastrarPessoa(new Cliente("Luciana", "4", f, 54));
			adm.cadastrarPessoa(new Cliente("Lula", "5", m, 54));
			adm.cadastrarPessoa(new Cliente("Dilma", "6", f, 54));
			adm.cadastrarPessoa(new Cliente("Fernando Collor", "7", m, 54));
			adm.cadastrarPessoa(new Cliente("Russel", "8", m, 54));
			adm.cadastrarPessoa(new Funcionario("Saulo Guilhermino", "9", m, 54));
			adm.cadastrarPessoa(new Funcionario("Alexandre", "11", m, 54));
			//erro
			adm.cadastrarPessoa(new Cliente("Wowboy", "11", m, 54));
		} catch(ClienteJaCadastradoException e) {
			e.printStackTrace();
		}

		try {

			adm.cadastrarImpressora(new Impressora("HP", "1a", 200, 0.01d));
			adm.cadastrarImpressora(new Impressora("HP", "1b", 200, 0.01d));
			adm.cadastrarImpressora(new Impressora("HP", "1c", 200, 0.01d));
			adm.cadastrarImpressora(new Impressora("HP", "1d", 200, 0.01d));
			adm.cadastrarImpressora(new Impressora("HP", "1e", 200, 0.01d));
			adm.cadastrarImpressora(new Impressora("HP", "1f", 200, 0.01d));
			adm.cadastrarImpressora(new Impressora("HP", "1g", 200, 0.01d));
			adm.cadastrarImpressora(new Impressora("HP", "1h", 200, 0.01d));
			adm.cadastrarImpressora(new Impressora("HP", "1i", 200, 0.01d));
			//erro
			adm.cadastrarImpressora(new Impressora("HP", "1b", 200, 0.01d));
			adm.cadastrarImpressora(new Impressora("HP", "1d", 200, 0.01d));
		} catch (ImpressoraJaCadastradaException e) {
			e.printStackTrace();
		}
		try {
			adm.cadastrarAplicativo(new Aplicativo("Skype", 15, 15));
			adm.cadastrarAplicativo(new Aplicativo("Google Chrome", 10, 30));
			adm.cadastrarAplicativo(new Aplicativo("Firefox", 6, 10));
			adm.cadastrarAplicativo(new Aplicativo("Spotfy", 30, 12));
			adm.cadastrarAplicativo(new Aplicativo("Skyper", 13, 12));
			adm.cadastrarAplicativo(new Aplicativo("Gmail", 14, 55));
			adm.cadastrarAplicativo(new Aplicativo("Explorer", 15, 15));
			adm.cadastrarAplicativo(new Aplicativo("WMP", 13, 35));
			adm.cadastrarAplicativo(new Aplicativo("UTorrent", 20, 19));
			//erro
			adm.cadastrarAplicativo(new Aplicativo("Skype", 15, 15));
			adm.cadastrarAplicativo(new Aplicativo("Skype", 15, 15));
		} catch (AplicativoJaCadastradoException e) {
			e.printStackTrace();
		}

		try {
			adm.ligarComputador("9", "1");
			adm.ligarComputador("9", "3");
			adm.ligarComputador("9", "4");
			adm.ligarComputador("9", "5");
			adm.ligarComputador("11", "2");
			adm.ligarComputador("11", "7");
			adm.ligarComputador("11", "6");

		} catch (ComputadorLigadoException e) {
			e.printStackTrace();
		} catch (PessoaNaoEncontradaException e) {
			e.printStackTrace();
		} catch (PessoaSemPermissaoException e) {
			e.printStackTrace();
		} catch (ComputadorNaoEncontradoException e) {
			e.printStackTrace();
		} */
	}

}
