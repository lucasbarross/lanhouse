package br.ufpe.cin.lanhouse.fachada;
import br.ufpe.cin.lanhouse.basicas.*;
import br.ufpe.cin.lanhouse.exceptions.*;
import br.ufpe.cin.lanhouse.negocios.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Administrador {

    private CadastroAplicativos cadastroAplicativos;
    private CadastroComputadores cadastroComputadores;
    private CadastroImpressoras cadastroImpressoras;
    private CadastroPessoas cadastroPessoas;

    public Administrador(CadastroAplicativos cadastroAplicativos, CadastroComputadores cadastroComputadores, CadastroImpressoras cadastroImpressoras, CadastroPessoas cadastroPessoas) {
        this.cadastroAplicativos = cadastroAplicativos;
        this.cadastroComputadores = cadastroComputadores;
        this.cadastroImpressoras = cadastroImpressoras;
        this.cadastroPessoas = cadastroPessoas;
    }

    public Aplicativo procurarApp(String nome) throws AppNaoEncontradoException {
        return cadastroAplicativos.procurar(nome);
    }

    public String usarComputador(String cpf) throws PessoaNaoEncontradaException, SemComputadorException {
        Pessoa usuario = cadastroPessoas.procurar(cpf);
        return usuario.usarComputador();
    }

}