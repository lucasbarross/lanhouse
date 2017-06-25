package br.ufpe.cin.lanhouse.basicas;

import br.ufpe.cin.lanhouse.exceptions.*;
import br.ufpe.cin.lanhouse.repositorios.RepositorioListaAplicativos;

public class Computador {

	private final String id;
	private int ram;
	private boolean ligado = false;
	private Cliente cliente = null;
	private int ram_ocupada = 0;
    private RepositorioListaAplicativos appsExecucao;

	public Computador(String id, int ram){
        this.appsExecucao = new RepositorioListaAplicativos();
		this.id = id;
		this.ram = ram;
	}

	//Liga o PC
	public void ligar() throws ComputadorLigadoException {
		if(this.ligado) {
			throw new ComputadorLigadoException(this.id);
		}
        this.ligado = true;
	}

	//Desliga o PC
	public void desligar() throws ComputadorDesligadoException, ComputadorUtilizadoException {
		if(!this.ligado) {
			throw new ComputadorDesligadoException(this.id);
		}
		if(this.cliente != null) {
			throw new ComputadorUtilizadoException(this.id);
		}
        this.ligado = false;
	}

	public String desconectarCliente() throws SemClienteException {
		if(this.cliente != null) {
		    this.appsExecucao = new RepositorioListaAplicativos();
			return this.cliente.desconectarComputador();
		} else {
			throw new SemClienteException(this.id);
		}
	}

	//Funcao usada mais abaixo, informa se o PC ta ligado ou desligado
	public String getEstado(){
	    String estado;
		if(this.ligado){
			estado = "Ligado";
		}else{
			estado = "Desligado";
		}
		return estado;
	}

	public String getId(){
		return this.id;
	}
	
	//Funcao usada mais abaixo, informa o usuario que esta usando o computador 
	public String getUsuario(){
	    String usuario;
		if(this.cliente == null){
			usuario = "------";
		}else{
			usuario = this.cliente.getNome();
		}
		return usuario;
	}
	
	//Adicionar cliente ao PC
    public void setCliente(Cliente cliente) throws ComputadorUtilizadoException, ComputadorDesligadoException {
		if(!this.ligado) {
			throw new ComputadorDesligadoException(this.id);
		}
		if(this.cliente == null) {
			this.cliente = cliente;
		} else {
			throw new ComputadorUtilizadoException(this.id);
		}
    }

    //Executa app
	public String executar(Aplicativo app) throws AplicativoEmExecucaoException, SemRamException {
        if(this.appsExecucao.existe(app.getNome())){
            throw new AplicativoEmExecucaoException(app.getNome());
        }
		if(this.ram_ocupada +app.getRamNecessaria() > this.ram){
			throw new SemRamException(this.id, app.getNome());
	   	}
        this.appsExecucao.inserir(app);
        this.ram_ocupada += app.getRamNecessaria();
		return app.executar();
	}
	
	//Encerra app, mata processos
	public String encerrar(Aplicativo app) throws AplicativoNaoEncontradoException {
        this.appsExecucao.remover(app.getNome());
        this.ram_ocupada -= app.getRamNecessaria();
		return app.encerrar();
	}


	// Informa estado atual da maquina
	public String estadoAtual(){
        return "Id: " + this.id + '\n'+
				"Estado: " + this.getEstado() + '\n' +
				"Usuario: " + this.getUsuario() + '\n'+
				"RAM Total: " + this.ram + '\n'+
				"RAM Disponivel: " + (this.ram - this.ram_ocupada) + '\n'+
				"Aplicativos em execução: " + this.appsExecucao.getApps() +'\n';
	}

    public boolean comparar(String id) {
        return this.id.equals(id);
    }
}
