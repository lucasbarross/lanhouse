package br.ufpe.cin.lanhouse.fachada;
import br.ufpe.cin.lanhouse.basicas.Aplicativo;
import br.ufpe.cin.lanhouse.exceptions.AppNaoEncontradoException;
import br.ufpe.cin.lanhouse.negocios.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Administrador {

    private CadastroAplicativos cadastroAplicativos;
    private CadastroComputadores cadastroComputadores;
    private CadastroImpressoras cadastroImpressoras;
    private CadastroPessoas cadastroPessoas;

    public void lerConfig() throws IOException {
        FileReader entrada = new FileReader("config.txt");
        BufferedReader br = new BufferedReader(entrada);
        String linha = br.readLine();
        boolean array;

        array = linha.equals("array");

        cadastroAplicativos= new CadastroAplicativos(array);
        cadastroComputadores = new CadastroComputadores(array);
        cadastroImpressoras = new CadastroImpressoras(array);
        cadastroPessoas = new CadastroPessoas(array);
    }

    public Aplicativo procurarApp(String nome) throws AppNaoEncontradoException {
        return cadastroAplicativos.procurar(nome);
    }


}
