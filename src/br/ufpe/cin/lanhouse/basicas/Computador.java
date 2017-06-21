package br.ufpe.cin.lanhouse.basicas;
/**
 * Created by sgfl on 16/06/2017.
 */
import br.ufpe.cin.lanhouse.exceptions.*;
import br.ufpe.cin.lanhouse.repositorios.RepositorioListaAplicativos;

public class Computador {

	private final String id;
	private final int ram;
	private boolean ligado;
	private Cliente cliente;
	private int ram_ocupada = 0;
    private final RepositorioListaAplicativos appsExecucao;

	public Computador(String id, int ram){
        appsExecucao = new RepositorioListaAplicativos();
		this.id = id;
		this.ram = ram;
	}

	public void ligar() throws ComputadorLigadoException {
		if(ligado) {
			throw new ComputadorLigadoException();
		}
		ligado = true;
	}

	public void desligar() throws ComputadorDesligadoException {
		if(!ligado) {
			throw new ComputadorDesligadoException();
		}
		ligado = false;
	}

	public String desconectarCliente() throws SemClienteException {
		if(this.cliente != null) {
			return this.cliente.desconectarComputador();
		} else {
			throw new SemClienteException();
		}
	}

	public String getEstado(){
		if(ligado){
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
			return ""+this.cliente.getNome();
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

	public String executar(Aplicativo app) throws AppEmExecucaoException, SemRamException {
        if(appsExecucao.existe(app.getNome())){
            throw new AppEmExecucaoException();
        }
		if(ram_ocupada+app.getRamNecessaria() > ram){
			throw new SemRamException();
	   	}
		appsExecucao.inserir(app);
		ram_ocupada += app.getRamNecessaria();
		return app.executar();
	}

	public String encerrar(Aplicativo app) throws AppNaoEncontradoException{
		appsExecucao.remover(app.getNome());
		ram_ocupada = ram_ocupada - app.getRamNecessaria();
		return app.encerrar();
	}


	/* observar estado atual da mÃ¡quina */
	public String estadoAtual(){
		return "Id: " + this.getId() + '\n'+
				"Estado: " + this.getEstado() + '\n' +
				"Usuario: " + this.getUsuario() + '\n'+
				"RAM Total: " + this.ram + '\n'+
				"RAM Disponivel: " + (this.ram - this.ram_ocupada) + '\n'+
				"Aplicativos em execução: " + appsExecucao.getApps();
	}

}
