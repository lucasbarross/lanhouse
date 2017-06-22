package br.ufpe.cin.lanhouse.basicas;

import br.ufpe.cin.lanhouse.exceptions.*;
import br.ufpe.cin.lanhouse.repositorios.RepositorioListaAplicativos;

/**
 * Created by sgfl on 16/06/2017.
 */

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

	public void ligar() throws ComputadorLigadoException {
		if(this.ligado) {
			throw new ComputadorLigadoException(id);
		}
        this.ligado = true;
	}

	public void desligar() throws ComputadorDesligadoException {
		if(!this.ligado) {
			throw new ComputadorDesligadoException(id);
		}
        this.ligado = false;
	}

	public String desconectarCliente() throws SemClienteException {
		if(this.cliente != null) {
			return this.cliente.desconectarComputador();
		} else {
			throw new SemClienteException(id);
		}
	}

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

	public String getUsuario(){
	    String usuario;
		if(this.cliente == null){
			usuario = "------";
		}else{
			usuario = this.cliente.getNome();
		}
		return usuario;
	}

    public void setCliente(Cliente cliente) throws ComputadorUtilizadoException, ComputadorDesligadoException {
		if(!this.ligado) {
			throw new ComputadorDesligadoException(id);
		}
		if(this.cliente == null) {
			this.cliente = cliente;
		} else {
			throw new ComputadorUtilizadoException(id);
		}
    }

	public String executar(Aplicativo app) throws AplicativoEmExecucaoException, SemRamException {
        if(this.appsExecucao.existe(app.getNome())){
            throw new AplicativoEmExecucaoException(app.getNome());
        }
		if(this.ram_ocupada +app.getRamNecessaria() > this.ram){
			throw new SemRamException(id, app.getNome());
	   	}
        this.appsExecucao.inserir(app);
        this.ram_ocupada += app.getRamNecessaria();
		return app.executar();
	}

	public String encerrar(Aplicativo app) throws AplicativoNaoEncontradoException {
        this.appsExecucao.remover(app.getNome());
        this.ram_ocupada -= app.getRamNecessaria();
		return app.encerrar();
	}


	/* observar estado atual da mÃ¡quina */
	public String estadoAtual(){
        return "Id: " + this.id + '\n'+
				"Estado: " + this.getEstado() + '\n' +
				"Usuario: " + this.getUsuario() + '\n'+
				"RAM Total: " + this.ram + '\n'+
				"RAM Disponivel: " + (this.ram - this.ram_ocupada) + '\n'+
				"Aplicativos em execução: " + this.appsExecucao.getApps();
	}

    public boolean comparar(String id) {
        return this.id.equals(id);
    }
}
