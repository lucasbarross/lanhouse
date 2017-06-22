package br.ufpe.cin.lanhouse.fachada;
import br.ufpe.cin.lanhouse.basicas.*;
import br.ufpe.cin.lanhouse.exceptions.*;
import br.ufpe.cin.lanhouse.interfaces.*;
import br.ufpe.cin.lanhouse.negocios.*;

public class Administrador {

    private CadastroAplicativos cadastroAplicativos;
    private CadastroComputadores cadastroComputadores;
    private CadastroImpressoras cadastroImpressoras;
    private CadastroPessoas cadastroPessoas;

    public Administrador(RepositorioAplicativos repositorioAplicativos, RepositorioComputadores repositorioComputadores, RepositorioImpressoras repositorioImpressoras, RepositorioPessoas repositorioPessoas) {
        this.cadastroAplicativos = new CadastroAplicativos(repositorioAplicativos);
        this.cadastroComputadores = new CadastroComputadores(repositorioComputadores);
        this.cadastroImpressoras = new CadastroImpressoras(repositorioImpressoras);
        this.cadastroPessoas = new CadastroPessoas(repositorioPessoas);
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

    public void removerAplicativo(String nome) throws AplicativoNaoEncontradoException {
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

    public void atualizarAplicativo(Aplicativo aplicativo) throws AplicativoNaoEncontradoException {
        this.cadastroAplicativos.atualizar(aplicativo);
    }

    public String executarApp(String cpfCliente, String nomeApp) throws PessoaNaoEncontradaException, AplicativoNaoEncontradoException, PessoaSemPermissaoException, AplicativoEmExecucaoException, SemComputadorException, SemRamException {
        Pessoa cliente = this.cadastroPessoas.procurar(cpfCliente);
        Aplicativo app = this.cadastroAplicativos.procurar(nomeApp);
        if(!(cliente instanceof Cliente)) {
            throw new PessoaSemPermissaoException(cliente.getNome(), cliente.getCpf());
        }
        return ((Cliente) cliente).executarAplicativo(app);
    }

    public String encerrarApp(String cpfCliente, String nomeApp) throws AplicativoNaoEncontradoException, PessoaNaoEncontradaException, PessoaSemPermissaoException {
        Pessoa cliente = this.cadastroPessoas.procurar(cpfCliente);
        Aplicativo app = this.cadastroAplicativos.procurar(nomeApp);
        if(!(cliente instanceof Cliente)) {
            throw new PessoaSemPermissaoException(cliente.getNome(), cliente.getCpf());
        }
        return ((Cliente) cliente).encerrarAplicativo(app);
    }

    public Aplicativo procurarApp(String nome) throws AplicativoNaoEncontradoException {
        return this.cadastroAplicativos.procurar(nome);
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

    public void renomearAplicativo(String nomeAntigo, String novoNome) throws AplicativoNaoEncontradoException {
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
        Pessoa usuario = this.cadastroPessoas.procurar(cpf);
        return usuario.usarComputador();
    }

    public void conectarCliente(String cpfFuncionario, String cpfCliente, String id) throws PessoaNaoEncontradaException, ComputadorNaoEncontradoException, ClienteComComputadorException, ComputadorUtilizadoException, PessoaSemPermissaoException, ComputadorDesligadoException {
        Pessoa funcionario = this.cadastroPessoas.procurar(cpfFuncionario);
        Pessoa cliente = this.cadastroPessoas.procurar(cpfCliente);
        Computador computador = this.cadastroComputadores.procurar(id);
        if(!(funcionario instanceof Funcionario)){
            throw new PessoaSemPermissaoException(funcionario.getNome(), funcionario.getCpf());
        }else if(!(cliente instanceof Cliente)) {
            throw new PessoaSemPermissaoException(cliente.getNome(), cliente.getCpf());
        }
        ((Funcionario) funcionario).conectarCliente(((Cliente) cliente), computador);
    }

    public void passarTempo(String cpfFuncionario) throws PessoaSemPermissaoException, PessoaNaoEncontradaException {
        Pessoa funcionario = this.cadastroPessoas.procurar(cpfFuncionario);
        if(!(funcionario instanceof Funcionario)) {
            throw new PessoaSemPermissaoException(funcionario.getNome(), funcionario.getCpf());
        }
        ((Funcionario) funcionario).passarTempo();
    }

    public void ligarComputador(String id) throws ComputadorLigadoException, ComputadorNaoEncontradoException {
        Computador computador = this.cadastroComputadores.procurar(id);
        computador.ligar();
    }
    public void desligarComputador(String id) throws ComputadorDesligadoException, ComputadorNaoEncontradoException {
        Computador computador = this.cadastroComputadores.procurar(id);
        computador.desligar();
    }

    public void desconectarCliente(String cpfFuncionario, String id) throws ComputadorNaoEncontradoException, PessoaNaoEncontradaException, SemClienteException, PessoaSemPermissaoException {
        Pessoa funcionario = this.cadastroPessoas.procurar(cpfFuncionario);
        Computador computador = this.cadastroComputadores.procurar(id);
        if(!(funcionario instanceof Funcionario)) {
            throw new PessoaSemPermissaoException(funcionario.getNome(), funcionario.getCpf());
        }
        ((Funcionario) funcionario).desconectarCliente(computador);
    }

    public void cadastrarComputador(Computador computador) throws SemEspacoComputadoresException, ComputadorJaCadastradoException {
        this.cadastroComputadores.cadastrar(computador);
    }

    public void instalarAplicativo(Aplicativo aplicativo) throws SemEspacoAplicativosException, AplicativoJaCadastradoException {
        this.cadastroAplicativos.cadastrar(aplicativo);
    }

    public void cadastrarImpressora(Impressora impressora) throws SemEspacoImpressoraException, ImpressoraJaCadastradaException {
        this.cadastroImpressoras.cadastrar(impressora);
    }

    public void cadastrarPessoa(Pessoa pessoa) throws PessoaJaCadastradaException {
        this.cadastroPessoas.cadastrar(pessoa);
    }
}