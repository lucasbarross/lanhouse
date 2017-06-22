package br.ufpe.cin.lanhouse.basicas;

import br.ufpe.cin.lanhouse.exceptions.*;
import br.ufpe.cin.lanhouse.repositorios.RepositorioListaAplicativos;

/**
 * Created by sgfl on 16/06/2017.
 */

public class Computador {

	private final String id;
	private int ram;
	private boolean ligado;
	private Cliente cliente;
	private int ram_ocupada;
    private RepositorioListaAplicativos appsExecucao;

	public Computador(String id, int ram){
        this.appsExecucao = new RepositorioListaAplicativos();
		this.id = id;
		this.ram = ram;
	}

	public void ligar() throws ComputadorLigadoException {
		if(this.ligado) {
			throw new ComputadorLigadoException();
		}
        this.ligado = true;
	}

	public void desligar() throws ComputadorDesligadoException {
		if(!this.ligado) {
			throw new ComputadorDesligadoException();
		}
        this.ligado = false;
	}

	public String desconectarCliente() throws SemClienteException {
		if(this.cliente != null) {
			return this.cliente.desconectarComputador();
		} else {
			throw new SemClienteException();
		}
	}

	public String getEstado(){
		if(this.ligado){
			return "Ligado";
		}else{
			return "Desligado";
		}
	}

	public String getId(){
		return this.id;
	}

	public String getUsuario(){
		if(this.cliente == null){
			return "------";
		}else{
			return this.cliente.getNome();
		}
	}

    public void setCliente(Cliente cliente) throws ComputadorUtilizadoException, ComputadorDesligadoException {
		if(!this.ligado) {
			throw new ComputadorDesligadoException();
		}
		if(this.cliente == null) {
			this.cliente = cliente;
		} else {
			throw new ComputadorUtilizadoException();
		}
    }

	public String executar(Aplicativo app) throws AplicativoEmExecucaoException, SemRamException {
        if(this.appsExecucao.existe(app.getNome())){
            throw new AplicativoEmExecucaoException();
        }
		if(this.ram_ocupada +app.getRamNecessaria() > this.ram){
			throw new SemRamException();
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
