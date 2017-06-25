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
         Instalaï¿½ï¿½o de aplicativos padrï¿½es no HD principal da LAN house.
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
			adm.instalarAplicativo(new Aplicativo("Colheita Feliz", 50, 10000));
		} catch (SemEspacoAplicativosException e1) {
			System.out.println(e1.getMessage());
		} catch (AplicativoJaCadastradoException e1) {
			System.out.println(e1.getMessage());
		}


        /*
         * 	TESTE 1
         	Funciona sem erros;
         	Cadastra dois funcionarios, dois clientes e quatro computadores;
         	Liga os computadores, conecta os clientes a dois deles e faz os clientes e um dos funcionarios usarem o computador, imprimindo as informaï¿½ï¿½es;
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
			adm.encerrarApp("823.597.450-93", "Planeta Minecraft");
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
			System.out.println("");
		}

		/*
		* 	TESTE 2
		* 	Funciona sem erros;
			Cadastra 4 impressoras, lista elas, remove uma impressora e lista de novo;
			Printa o estado da impressora 2, atualiza ela, printa de novo atualizada;
			Printa o estado das impressoras 0 e 3, utiliza elas e printa o estado de novo;
			Cadastra mais duas impressoras, listando elas apÃ³s cada impressora adicionada;
			Remove uma impressora, lista as impressoras;
			Adiciona uma nova, lista de novo e printa o estado da ultima adicionada;
		 */

		try {
			System.out.println("----------------- TESTE 2 -----------------");
			adm.cadastrarImpressora(new Impressora("HP", "000", 10, 0.2));
			adm.cadastrarImpressora(new Impressora("HP", "001", 10, 0.2));
			adm.cadastrarImpressora(new Impressora("Trivial", "002", 20, 0.05));
			adm.cadastrarImpressora(new Impressora("Trivial", "003", 20, 0.05));
			System.out.println(adm.listarImpressoras());
			adm.removerImpressora("001");
			System.out.println(adm.listarImpressoras());
			System.out.println(adm.getEstadoImpressora("002"));
			adm.atualizarImpressora(new Impressora("HP", "002", 15, 0.1));
			System.out.println(adm.getEstadoImpressora("002"));
			System.out.println(adm.getEstadoImpressora("000"));
			System.out.println(adm.getEstadoImpressora("003"));
			adm.recarregarPagina("000", 5);
			adm.recarregarPagina("003", 20);
			adm.recarregarTintaPreta("000");
			adm.recarregarTintaPreta("003");
			adm.recarregarTintaColorida("003");
			adm.imprimirEmPreto("000", 2);
			adm.imprimirEmColorido("003", 8);
			adm.imprimirEmPreto("003", 10);
			System.out.println(adm.getEstadoImpressora("000"));
			System.out.println(adm.getEstadoImpressora("003"));
			adm.cadastrarImpressora(new Impressora("IP", "001", 20, 0.02));
			System.out.println(adm.listarImpressoras());
			adm.cadastrarImpressora(new Impressora("IP", "004", 16, 0.03));
			System.out.println(adm.listarImpressoras());
			adm.removerImpressora("000");
			System.out.println(adm.listarImpressoras());
			adm.cadastrarImpressora(new Impressora("GAP", "005", 50, 0.01));
			System.out.println(adm.listarImpressoras());
			System.out.println(adm.getEstadoImpressora("005"));
		} catch (SemEspacoImpressoraException | ImpressoraJaCadastradaException | SemTintaPretaException | SemFolhaException | ImpressoraNaoEncontradaException | SemTintaColoridaException | SemEspacoPapelException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("----------------- FIM DO TESTE 2 ----------------- ");
			System.out.println("");
		}

		/*
		* 	TESTE 3
		* 	Funciona com erros;
			Tenta cadastrar um computador jÃ¡ cadastrado;
			Tenta conectar um usuario a um computador inexistente;
			Cadastra um computador novo;
			Tenta conectar um usuario a um computador desligado;
			Apaga o computador cadastrado e tenta conectar um cliente a ele posteriormente;
		 */
		
		try{
			System.out.println("----------------- TESTE 3 -----------------");
		    adm.cadastrarComputador(new Computador("2", 4000));
		    adm.conectarCliente("828.408.775-89", "823.597.450-93", "2");
		    adm.conectarCliente("828.408.775-89", "823.597.450-93", "5");
		    			
		} catch (ComputadorNaoEncontradoException e) {
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
		} try{
			adm.conectarCliente("828.408.775-89", "823.597.450-93", "5");
			
		} catch (ComputadorNaoEncontradoException e) {
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
		}
		try{
			adm.cadastrarComputador(new Computador("7", 4000));
			adm.conectarCliente("828.408.775-89", "823.597.450-93", "7");
			
		} catch (ComputadorNaoEncontradoException e) {
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
		} catch(SemEspacoComputadoresException e){
			System.out.println(e.getMessage());
		} catch(ComputadorJaCadastradoException e){
			System.out.println(e.getMessage());
		}
		try{
			adm.removerComputador("7");
			adm.conectarCliente("828.408.775-89", "823.597.450-93", "7");
		}catch (ComputadorNaoEncontradoException e) {
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
		}
		finally {
			System.out.println("----------------- FIM DO TESTE 3 ----------------- ");
			System.out.println("");
		}
		
		/*
         * 	TESTE 4
         	Funciona com erros;
         	Tenta armazenar um aplicativo muito grande para o tamanho do HD;
         	Tenta armazenar um aplicativo que ja existe;
         	Tenta procurar um aplicativo que não existe;
         	Tenta executar um aplicativo sem o computador ter RAM o suficiente;
         	Atualiza o aplicativo para uma versão que exige menos RAM;
         	Executa o aplicativo;
         	Tenta executar o aplicativo que já está aberto;
         */
		try {
			System.out.println("----------------- TESTE 4 -----------------");
			adm.instalarAplicativo(new Aplicativo("Pinball Online", 100000, 200));
		} catch (SemEspacoAplicativosException e) {
			System.out.println(e.getMessage());
		} catch (AplicativoJaCadastradoException e) {
			System.out.println(e.getMessage());
		}
		try {
			adm.instalarAplicativo(new Aplicativo("Planeta Minecraft", 10, 100));
		} catch (SemEspacoAplicativosException e) {
			System.out.println(e.getMessage());
		} catch (AplicativoJaCadastradoException e) {
			System.out.println(e.getMessage());
		}
		try {
			adm.procurarApp("Dolly Guaraná Web Services");
		} catch (AplicativoNaoEncontradoException e) {
			System.out.println(e.getMessage());
		}
		try {
			//Cliente cadastrado do Teste 1.
			adm.executarApp("823.597.450-93", "Colheita Feliz");
		} catch (PessoaNaoEncontradaException e) {
			System.out.println(e.getMessage());
		} catch (AplicativoNaoEncontradoException e) {
			System.out.println(e.getMessage());
		} catch (PessoaSemPermissaoException e) {
			System.out.println(e.getMessage());
		} catch (AplicativoEmExecucaoException e) {
			System.out.println(e.getMessage());
		} catch (SemComputadorException e) {
			System.out.println(e.getMessage());
		} catch (SemRamException e) {
			System.out.println(e.getMessage());
		}
		try {
			adm.atualizarAplicativo(new Aplicativo("Colheita Feliz", 1,10));
			adm.executarApp("823.597.450-93", "Colheita Feliz");
			System.out.println();
			System.out.println(adm.usarComputador("823.597.450-93"));
			adm.executarApp("823.597.450-93", "Colheita Feliz");
		} catch (AplicativoNaoEncontradoException e) {
			System.out.println(e.getMessage());
		} catch (SemEspacoAplicativosException e) {
			System.out.println(e.getMessage());
		} catch (PessoaNaoEncontradaException e) {
			System.out.println(e.getMessage());
		} catch (PessoaSemPermissaoException e) {
			System.out.println(e.getMessage());
		} catch (AplicativoEmExecucaoException e) {
			System.out.println(e.getMessage());
		} catch (SemComputadorException e) {
			System.out.println(e.getMessage());
		} catch (SemRamException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("----------------- FIM DO TESTE 4 -----------------");
		}
		
	}

}
