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
    
    /* 
      Todos os m�todos associados a (atualizar, remover, cadastrar, instalar) 
      est�o associados a manipula��o dos dados no reposit�rio
    */
    
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

    public void atualizarAplicativo(Aplicativo aplicativo) throws AplicativoNaoEncontradoException, SemEspacoAplicativosException {
        this.cadastroAplicativos.atualizar(aplicativo);
    }
    
    //Executa o app em determinado computador associado ao cliente que possui o CPF passado no m�todo.
    public String executarApp(String cpfCliente, String nomeApp) throws PessoaNaoEncontradaException, AplicativoNaoEncontradoException, PessoaSemPermissaoException, AplicativoEmExecucaoException, SemComputadorException, SemRamException {
        Pessoa cliente = this.cadastroPessoas.procurar(cpfCliente);
        Aplicativo app = this.cadastroAplicativos.procurar(nomeApp);
        if(!(cliente instanceof Cliente)) {
            throw new PessoaSemPermissaoException(cliente.getNome(), cliente.getCpf());
        }
        return ((Cliente) cliente).executarAplicativo(app);
    }
    
    //Encerra o app que est� sendo executado em determinado computador associado ao cliente que possui o CPF passado no m�todo.
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
    
    //Recarrega o atributo quantidade de papeis em determinada impressora associada ao id passado no m�todo.
    public void recarregarPagina(String id, int numeroPaginas) throws SemEspacoPapelException, ImpressoraNaoEncontradaException {
        Impressora impressora = this.cadastroImpressoras.procurar(id);
        impressora.recarregarPagina(numeroPaginas);
    }
    
    //Recarrega o atributo quantidade de tinta preta em determinada impressora associada ao id passado no m�todo.
    public void recarregarTintaPreta(String id) throws ImpressoraNaoEncontradaException {
        Impressora impressora = this.cadastroImpressoras.procurar(id);
        impressora.recarregarTintaPreta();
    }
    
    //Recarrega o atributo quantidade de tinta colorida em determinada impressora associada ao id passado no m�todo.
    public void recarregarTintaColorida(String id) throws ImpressoraNaoEncontradaException {
        Impressora impressora = this.cadastroImpressoras.procurar(id);
        impressora.recarregarTintaColorida();
    }
    
    //Faz com o que uma pessoa use o seu computador. Se for um cliente, retorna as info do PC que ele est� utilizando.
    //Se for um funcion�rio, retorna as informa��es dos clientes que est�o sendo atendidos por ele.
    public String usarComputador(String cpf) throws PessoaNaoEncontradaException, SemComputadorException {
        Pessoa usuario = this.cadastroPessoas.procurar(cpf);
        return usuario.usarComputador();
    }
    
    //Usa os poderes de funcionarios para associar determinado cliente em determinado computador.
    public void conectarCliente(String cpfFuncionario, String cpfCliente, String idComputador) throws PessoaNaoEncontradaException, ComputadorNaoEncontradoException, ClienteComComputadorException, ComputadorUtilizadoException, PessoaSemPermissaoException, ComputadorDesligadoException {
        Pessoa funcionario = this.cadastroPessoas.procurar(cpfFuncionario);
        Pessoa cliente = this.cadastroPessoas.procurar(cpfCliente);
        Computador computador = this.cadastroComputadores.procurar(idComputador);
        if(!(funcionario instanceof Funcionario)){
            throw new PessoaSemPermissaoException(funcionario.getNome(), funcionario.getCpf());
        }else if(!(cliente instanceof Cliente)) {
            throw new PessoaSemPermissaoException(cliente.getNome(), cliente.getCpf());
        }
        ((Funcionario) funcionario).conectarCliente(((Cliente) cliente), computador);
    }
    
    //Passa o tempo para todos os clientes associados ao funcionario que possui a identifica��o passada no m�todo.
    public void passarTempo(String cpfFuncionario) throws PessoaSemPermissaoException, PessoaNaoEncontradaException {
        Pessoa funcionario = this.cadastroPessoas.procurar(cpfFuncionario);
        if(!(funcionario instanceof Funcionario)) {
            throw new PessoaSemPermissaoException(funcionario.getNome(), funcionario.getCpf());
        }
        ((Funcionario) funcionario).passarTempo();
    }
    
    //Liga o computador que possui a identifica��o passada no m�todo.
    public void ligarComputador(String idComputador) throws ComputadorLigadoException, ComputadorNaoEncontradoException {
        Computador computador = this.cadastroComputadores.procurar(idComputador);
        computador.ligar();
    }
    
    //Desliga o computador que possui a identifica��o passada no m�todo.
    public void desligarComputador(String idComputador) throws ComputadorDesligadoException, ComputadorNaoEncontradoException, ComputadorUtilizadoException {
        Computador computador = this.cadastroComputadores.procurar(idComputador);
        computador.desligar();
    }
    
    //Usa os poderes de funcionario para dissociar o cliente do computador de id passado.
    public void desconectarCliente(String cpfFuncionario, String idComputador) throws ComputadorNaoEncontradoException, PessoaNaoEncontradaException, SemClienteException, PessoaSemPermissaoException {
        Pessoa funcionario = this.cadastroPessoas.procurar(cpfFuncionario);
        Computador computador = this.cadastroComputadores.procurar(idComputador);
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
    
    //Retorna as informa��es da impressora de identifica��o passada no m�todo.
    public String getEstadoImpressora(String id) throws ImpressoraNaoEncontradaException {
        Impressora impressora = this.cadastroImpressoras.procurar(id);
        return impressora.getEstado();
    }
}