package br.ufpe.cin.lanhouse.programa;

import br.ufpe.cin.lanhouse.basicas.*;
import br.ufpe.cin.lanhouse.exceptions.*;
import br.ufpe.cin.lanhouse.fachada.*;
import br.ufpe.cin.lanhouse.repositorios.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LanHouse {

	public static void main(String[] args) throws IOException, ConfigInvalidoException {
        Administrador adm;
        FileReader entrada;
        String linha;
        entrada = new FileReader("config.txt");
        try (BufferedReader br = new BufferedReader(entrada)) {
            linha = br.readLine();
            br.close();
        }
        if (linha.equals("array")) {
            adm = new Administrador(new RepositorioArrayAplicativos(), new RepositorioArrayComputadores(), new RepositorioArrayImpressoras(), new RepositorioArrayPessoas());
        } else if (linha.equals("lista")) {
            adm = new Administrador(new RepositorioListaAplicativos(), new RepositorioListaComputadores(), new RepositorioListaImpressoras(), new RepositorioListaPessoas());
        } else {
            throw new ConfigInvalidoException();
        }

        try {
		    adm.cadastrarPessoa(new Funcionario("Gabriel", "9", 'M', 19));
		    adm.cadastrarPessoa(new Funcionario("Vilma", "11", 'F', 18));
			adm.ligarComputador("9", "1");
			adm.ligarComputador("9", "3");
			adm.ligarComputador("9", "4");
			adm.ligarComputador("9", "5");
			adm.ligarComputador("11", "2");
			adm.ligarComputador("11", "7");
			adm.ligarComputador("11", "6");
		} catch (ComputadorLigadoException e) {
			System.out.println("O computador já está ligado");
		} catch (PessoaNaoEncontradaException e) {
            System.out.println("O cpf não existe");
        } catch (PessoaSemPermissaoException e) {
            System.out.println("A pessoa não tem permissao");
        } catch (ComputadorNaoEncontradoException e) {
            System.out.println("O computador não existe");
        } catch (PessoaJaCadastradaException e) {
            System.out.println("Essa pessoa já foi cadastrada");
        }
    }

}
