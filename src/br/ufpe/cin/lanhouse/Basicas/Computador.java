package br.ufpe.cin.lanhouse.Basicas;

import br.ufpe.cin.lanhouse.Exceptions.*;
import br.ufpe.cin.lanhouse.Repositorios.RepositorioListaAplicativos;

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
			return ""+this.cliente;
		}
	}

	public int getHD(){
		return this.hd;
	}

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

	public void executar(Aplicativo app) throws AppNaoEncontradoException, AppEmExecucaoException {
		if(app.getExecutado()){
			throw new AppEmExecucaoException();
		}else {
			app.executar();
		}
	}

	public void encerrar(Aplicativo app) throws AppNaoEncontradoException{
		ram_ocupada = ram_ocupada-app.getRamNecessaria();
        app.encerrar();
	}


	/* observar estado atual da mÃ¡quina */
	public String estadoAtual(){
		return "Estado: " + this.getEstado() + '\n' +
				"Usuario: " + this.getUsuario() + '\n'+
				"HD Total: " + this.getHD() + '\n'+
				"HD Disponivel: " + (this.getHD() - this.hd_ocupado) + '\n'+
				"RAM Total: " + this.getRAM() + '\n'+
				"RAM Disponivel: " + (this.getRAM() - this.ram_ocupada);
	}

}
