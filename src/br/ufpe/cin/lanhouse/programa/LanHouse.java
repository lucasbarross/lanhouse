package br.ufpe.cin.lanhouse.programa;

import br.ufpe.cin.lanhouse.basicas.*;
import br.ufpe.cin.lanhouse.exceptions.*;
import br.ufpe.cin.lanhouse.fachada.*;
import br.ufpe.cin.lanhouse.repositorios.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class LanHouse {

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
        
        /*
         Instalação de aplicativos padrões no HD principal da LAN house.
         */
        try {
			adm.instalarAplicativo(new Aplicativo("Skype", 2, 500));
			adm.instalarAplicativo(new Aplicativo("Discord", 1, 100));
			adm.instalarAplicativo(new Aplicativo("Eclipse", 5, 800));
			adm.instalarAplicativo(new Aplicativo("GTA V", 60, 2000));
			adm.instalarAplicativo(new Aplicativo("Chrome", 1, 1000));
			adm.instalarAplicativo(new Aplicativo("Firefox", 1, 500));
			adm.instalarAplicativo(new Aplicativo("Steam", 2, 50));
			adm.instalarAplicativo(new Aplicativo("Unity", 15, 1000));
			adm.instalarAplicativo(new Aplicativo("GitHub", 1, 75));
			adm.instalarAplicativo(new Aplicativo("Photoshop", 3, 800));
			adm.instalarAplicativo(new Aplicativo("Overwatch", 25, 2000));
			adm.instalarAplicativo(new Aplicativo("CS:GO", 20, 1500));
			adm.instalarAplicativo(new Aplicativo("Rocket League", 10, 1200));
			adm.instalarAplicativo(new Aplicativo("HeidiSQL",2, 125));
			adm.instalarAplicativo(new Aplicativo("Sublime", 1, 25));
			adm.instalarAplicativo(new Aplicativo("Spotify", 2, 300));
			adm.instalarAplicativo(new Aplicativo("Planeta Minecraft", 7, 1700));
			adm.instalarAplicativo(new Aplicativo("Colheita Feliz", 50, 2000));
		} catch (SemEspacoAplicativosException e1) {
			System.out.println(e1.getMessage());
		} catch (AplicativoJaCadastradoException e1) {
			System.out.println(e1.getMessage());
		}
        
        
        /*
         * 	TESTE 1
         	Funciona sem erros;
         	Cadastra dois funcionarios, dois clientes e quatro computadores;
         	Liga os computadores, conecta os clientes a dois deles e faz os clientes e um dos funcionarios usarem o computador, imprimindo as informações;
        */

        try {
        	System.out.println("----------------- TESTE 1 -----------------");
		    adm.cadastrarPessoa(new Funcionario("Gabriel", "828.408.775-89", 'M', 19));
		    adm.cadastrarPessoa(new Funcionario("Vilma", "651.065.171-84", 'F', 18));
		    adm.cadastrarPessoa(new Cliente("Lucas", "420.367.175-27", 'M', 18));
		    adm.cadastrarPessoa(new Cliente("Saulo", "823.597.450-93", 'M', 18));
		    adm.cadastrarComputador(new Computador("1", 4000));
		    adm.cadastrarComputador(new Computador("3", 8000));
		    adm.cadastrarComputador(new Computador("2", 4000));
		    adm.cadastrarComputador(new Computador("6", 4000));
		    adm.ligarComputador("1");
			adm.ligarComputador("2");
		    adm.conectarCliente("651.065.171-84", "420.367.175-27", "1");
		    adm.conectarCliente("828.408.775-89", "823.597.450-93", "2");
		    adm.executarApp("420.367.175-27", "Planeta Minecraft");
		    adm.executarApp("420.367.175-27", "Spotify");
		    adm.executarApp("823.597.450-93", "Planeta Minecraft");
			System.out.println(adm.usarComputador("420.367.175-27"));
			System.out.println(adm.usarComputador("823.597.450-93"));
			System.out.println(adm.usarComputador("651.065.171-84"));
			System.out.println(adm.usarComputador("828.408.775-89"));
		} catch (ComputadorLigadoException | PessoaJaCadastradaException | ComputadorNaoEncontradoException e) {
			System.out.println(e.getMessage());
		} catch (SemEspacoComputadoresException e) {
			System.out.println(e.getMessage());
		} catch (ComputadorJaCadastradoException e) {
			System.out.println(e.getMessage());
		} catch (PessoaNaoEncontradaException e) {
			System.out.println(e.getMessage());
		} catch (ClienteComComputadorException e) {
			System.out.println(e.getMessage());
		} catch (ComputadorUtilizadoException e) {
			System.out.println(e.getMessage());
		} catch (PessoaSemPermissaoException e) {
			System.out.println(e.getMessage());
		} catch (ComputadorDesligadoException e) {
			System.out.println(e.getMessage());
		} catch (SemComputadorException e) {
			System.out.println(e.getMessage());
		} catch (AplicativoNaoEncontradoException e) {
			System.out.println(e.getMessage());
		} catch (AplicativoEmExecucaoException e) {
			System.out.println(e.getMessage());
		} catch (SemRamException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("----------------- FIM DO TESTE 1 ----------------- ");
		}
    }

}
