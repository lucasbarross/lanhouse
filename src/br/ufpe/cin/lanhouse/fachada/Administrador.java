package br.ufpe.cin.lanhouse.fachada;
import br.ufpe.cin.lanhouse.basicas.*;
import br.ufpe.cin.lanhouse.exceptions.*;
import br.ufpe.cin.lanhouse.negocios.*;

public class Administrador {

    private final CadastroAplicativos cadastroAplicativos;
    private final CadastroComputadores cadastroComputadores;
    private final CadastroImpressoras cadastroImpressoras;
    private final CadastroPessoas cadastroPessoas;

    public Administrador(CadastroAplicativos cadastroAplicativos, CadastroComputadores cadastroComputadores, CadastroImpressoras cadastroImpressoras, CadastroPessoas cadastroPessoas) {
        this.cadastroAplicativos = cadastroAplicativos;
        this.cadastroComputadores = cadastroComputadores;
        this.cadastroImpressoras = cadastroImpressoras;
        this.cadastroPessoas = cadastroPessoas;
    }

    public void removerImpressora(String id) throws ImpressoraNaoEncontradaException {
        this.cadastroImpressoras.remover(id);
    }

    public void removerComputador(String id) throws ComputadorNaoEncontradoException {
        this.cadastroComputadores.remover(id);
    }

    public void removerPessoa(String cpf) throws PessoaNaoEncontradaException {
        this.cadastroPessoas.remover(cpf);
    }

    public void removerAplicativo(String nome) throws AppNaoEncontradoException {
        this.cadastroAplicativos.remover(nome);
    }

    public void atualizarImpressora(Impressora impressora) throws ImpressoraNaoEncontradaException {
        this.cadastroImpressoras.atualizar(impressora);
    }

    public void atualizarComputador(Computador computador) throws ComputadorNaoEncontradoException {
        this.cadastroComputadores.atualizar(computador);
    }

    public void atualizarPessoa(Pessoa pessoa) throws PessoaNaoEncontradaException {
        this.cadastroPessoas.atualizar(pessoa);
    }

    public void atualizarAplicativo(Aplicativo aplicativo) throws AppNaoEncontradoException {
        this.cadastroAplicativos.atualizar(aplicativo);
    }

    public String executarApp(String cpfCliente, String nomeApp) throws PessoaNaoEncontradaException, AppNaoEncontradoException, PessoaSemPermissaoException, AppEmExecucaoException, SemComputadorException, SemRamException {
        Pessoa cliente = cadastroPessoas.procurar(cpfCliente);
        Aplicativo app = cadastroAplicativos.procurar(nomeApp);
        if(!(cliente instanceof Cliente)) {
            throw new PessoaSemPermissaoException();
        }
        return ((Cliente) cliente).executarAplicativo(app);
    }

    public String encerrarApp(String cpfCliente, String nomeApp) throws AppNaoEncontradoException, PessoaNaoEncontradaException, PessoaSemPermissaoException {
        Pessoa cliente = cadastroPessoas.procurar(cpfCliente);
        Aplicativo app = cadastroAplicativos.procurar(nomeApp);
        if(!(cliente instanceof Cliente)) {
            throw new PessoaSemPermissaoException();
        }
        return ((Cliente) cliente).encerrarAplicativo(app);
    }

    public Aplicativo procurarApp(String nome) throws AppNaoEncontradoException {
        return cadastroAplicativos.procurar(nome);
    }

    public String listarImpressoras() {
        return this.cadastroImpressoras.listarImpressoras();
    }

    public String listarAplicativos() {
        return this.cadastroAplicativos.listarAplicativos();
    }

    public String listarComputadores() {
        return this.cadastroComputadores.listarComputadores();
    }

    public String listarPessoas() {
        return this.cadastroPessoas.listarPessoas();
    }

    public void renomearAplicativo(String nomeAntigo, String novoNome) throws AppNaoEncontradoException {
        Aplicativo app = this.cadastroAplicativos.procurar(nomeAntigo);
        app.renomear(novoNome);
    }

    public void imprimirEmPreto(String id, int numeroPaginas) throws ImpressoraNaoEncontradaException, SemTintaPretaException, SemFolhaException {
        Impressora impressora = this.cadastroImpressoras.procurar(id);
        impressora.imprimirEmPreto(numeroPaginas);
    }

    public void imprimirEmColorido(String id, int numeroPaginas) throws SemFolhaException, SemTintaColoridaException, ImpressoraNaoEncontradaException {
        Impressora impressora = this.cadastroImpressoras.procurar(id);
        impressora.imprimirEmColorido(numeroPaginas);
    }

    public void recarregarPagina(String id, int numeroPaginas) throws SemEspacoPapelException, ImpressoraNaoEncontradaException {
        Impressora impressora = this.cadastroImpressoras.procurar(id);
        impressora.recarregarPagina(numeroPaginas);
    }

    public void recarregarTintaPreta(String id) throws ImpressoraNaoEncontradaException {
        Impressora impressora = this.cadastroImpressoras.procurar(id);
        impressora.recarregarTintaPreta();
    }

    public void recarregarTintaColorida(String id) throws ImpressoraNaoEncontradaException {
        Impressora impressora = this.cadastroImpressoras.procurar(id);
        impressora.recarregarTintaColorida();
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

    public void cadastrarComputador(Computador computador) throws SemEspacoComputadoresException, ComputadorJaCadastradoException {
        this.cadastroComputadores.cadastrar(computador);
    }

    public void instalarAplicativo(Aplicativo aplicativo) throws SemEspacoAplicativosException, AppJaCadastradoException {
        this.cadastroAplicativos.cadastrar(aplicativo);
    }

    public void cadastrarImpressora(Impressora impressora) throws SemEspacoImpressoraException, ImpressoraJaCadastradaException {
        this.cadastroImpressoras.cadastrar(impressora);
    }

    public void cadastrarPessoa(Pessoa pessoa) throws PessoaJaCadastradaException, SemEspacoAplicativosException {
        this.cadastroPessoas.cadastrar(pessoa);
    }
}