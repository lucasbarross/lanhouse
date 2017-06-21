package br.ufpe.cin.lanhouse.programa;

import br.ufpe.cin.lanhouse.basicas.*;
import br.ufpe.cin.lanhouse.fachada.Administrador;
import br.ufpe.cin.lanhouse.negocios.*;
import br.ufpe.cin.lanhouse.repositorios.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LanHouse {

	public static void main(String[] args) {
		try {
			FileReader entrada = null;
			entrada = new FileReader("config.txt");
			BufferedReader br = new BufferedReader(entrada);
			String linha = null;
			linha = br.readLine();
			boolean array;
			array = linha.equals("array");
			Administrador adm = new Administrador(new CadastroAplicativos(array), new CadastroComputadores(array), new CadastroImpressoras(array), new CadastroPessoas(array));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
