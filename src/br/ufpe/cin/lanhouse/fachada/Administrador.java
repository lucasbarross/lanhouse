package br.ufpe.cin.lanhouse.fachada;
import br.ufpe.cin.lanhouse.basicas.*;
import br.ufpe.cin.lanhouse.exceptions.*;
import br.ufpe.cin.lanhouse.negocios.*;

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

    public void conectarCliente(String cpfFuncionario, String cpfCliente, String id) throws PessoaNaoEncontradaException, ComputadorNaoEncontradoException, ClienteComComputadorException, ComputadorUtilizadoException, PessoaSemPermissaoException, ComputadorDesligadoException {
        Pessoa funcionario = cadastroPessoas.procurar(cpfFuncionario);
        Pessoa cliente = cadastroPessoas.procurar(cpfCliente);
        Computador computador = cadastroComputadores.procurar(id);
        if(!(funcionario instanceof Funcionario) || !(cliente instanceof Cliente)) {
            throw new PessoaSemPermissaoException();
        }
        ((Funcionario) funcionario).conectarCliente(((Cliente) cliente), computador);
    }

    public void passarTempo(String cpfFuncionario) throws PessoaSemPermissaoException, PessoaNaoEncontradaException {
        Pessoa funcionario = cadastroPessoas.procurar(cpfFuncionario);
        if(!(funcionario instanceof Funcionario)) {
            throw new PessoaSemPermissaoException();
        }
        ((Funcionario) funcionario).passarTempo();
    }

    public void ligarComputador(String cpfFuncionario, String id) throws ComputadorLigadoException, ComputadorNaoEncontradoException, PessoaNaoEncontradaException, PessoaSemPermissaoException {
        Pessoa funcionario = cadastroPessoas.procurar(cpfFuncionario);
        Computador computador = cadastroComputadores.procurar(id);
        if(!(funcionario instanceof Funcionario)) {
            throw new PessoaSemPermissaoException();
        }
        ((Funcionario) funcionario).ligarComputador(computador);
    }
    public void desligarComputador(String cpfFuncionario, String id) throws ComputadorDesligadoException, ComputadorNaoEncontradoException, PessoaNaoEncontradaException, PessoaSemPermissaoException {
        Pessoa funcionario = cadastroPessoas.procurar(cpfFuncionario);
        Computador computador = cadastroComputadores.procurar(id);
        if(!(funcionario instanceof Funcionario)) {
            throw new PessoaSemPermissaoException();
        }
        ((Funcionario) funcionario).desligarComputador(computador);
    }

    public void desconectarCliente(String cpfFuncionario, String id) throws ComputadorNaoEncontradoException, PessoaNaoEncontradaException, SemClienteException, PessoaSemPermissaoException {
        Pessoa funcionario = cadastroPessoas.procurar(cpfFuncionario);
        Computador computador = cadastroComputadores.procurar(id);
        if(!(funcionario instanceof Funcionario)) {
            throw new PessoaSemPermissaoException();
        }
        ((Funcionario) funcionario).desconectarCliente(computador);
    }

    public void cadastrarComputador(Computador computador) throws SemEspacoComputadoresException {
        this.cadastroComputadores.cadastrar(computador);
    }

    public void instalarAplicativo(Aplicativo aplicativo) throws SemEspacoAplicativosException {
        this.cadastroAplicativos.cadastrar(aplicativo);
    }

    public void cadastrarImpressora(Impressora impressora) throws SemEspacoImpressoraException, ImpressoraJaCadastradaException {
        this.cadastroImpressoras.cadastrar(impressora);
    }

    public void cadastrarPessoa(Pessoa pessoa) {
        this.cadastrarPessoa(pessoa);
    }
}