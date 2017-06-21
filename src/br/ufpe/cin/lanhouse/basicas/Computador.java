package br.ufpe.cin.lanhouse.basicas;

import br.ufpe.cin.lanhouse.exceptions.*;
import br.ufpe.cin.lanhouse.repositorios.RepositorioListaAplicativos;

public class Computador {

	private String id;
	private int hd;
	private int ram;
	private boolean ligado;
	private Cliente cliente;
	private int hd_ocupado = 0;
	private int ram_ocupada = 0;
	private boolean pronto = false;
    private RepositorioListaAplicativos appsExecucao;

	public Computador(String id, int ram){
        appsExecucao = new RepositorioListaAplicativos();
		this.id = id;
		this.hd = 1000;
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

	public void desconectarCliente() throws SemClienteException {
		if(this.cliente != null) {
			this.cliente.desconectarComputador();
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

	public int getRAM(){
		return this.ram;
	}

	public String getUsuario(){
		if(this.cliente == null){
			return "------";
		}else{
			return ""+this.cliente.getNome();
		}
	}

	public int getHD(){
		return this.hd;
	}

    public void setCliente(Cliente cliente) throws ComputadorUtilizadoException {
		if(this.cliente == null) {
			this.cliente = cliente;
		} else {
			throw new ComputadorUtilizadoException();
		}
    }

	public void executar(Aplicativo app) throws AppNaoEncontradoException, AppEmExecucaoException, SemRamException {
        if(appsExecucao.existe(app.getNome())){
            throw new AppEmExecucaoException();
        }else{
            if(ram_ocupada+app.getRamNecessaria()>ram){
                throw new SemRamException();
          } else {
                appsExecucao.inserir(app);
                app.executar();
                ram_ocupada += app.getRamNecessaria();
          }
        }
	}

	public void encerrar(Aplicativo app) throws AppNaoEncontradoException{
            appsExecucao.remover(app.getNome());
            ram_ocupada = ram_ocupada - app.getRamNecessaria();
            app.encerrar();
	}


	/* observar estado atual da mÃ¡quina */
	public String estadoAtual(){
		return "Estado: " + this.getEstado() + '\n' +
				"Usuario: " + this.getUsuario() + '\n'+
				"HD Total: " + this.getHD() + '\n'+
				"HD Disponivel: " + (this.getHD() - this.hd_ocupado) + '\n'+
				"RAM Total: " + this.getRAM() + '\n'+
				"RAM Disponivel: " + (this.getRAM() - this.ram_ocupada) + '\n'+
				"Aplicativos em execução: " + appsExecucao.getApps();
	}

}
