package br.ufpe.cin.lanhouse.Basicas;

import br.ufpe.cin.lanhouse.Exceptions.*;

public class Computador {

	private String id;
	private int hd;
	private int ram;
	private boolean ligado;
	private Cliente cliente;
	private Aplicativo apps [] = new Aplicativo [100];
	private int hd_ocupado = 0;
	private int ram_ocupada = 0;
	private boolean preparado = false;

	public Computador(String id, int hd, int ram){
		this.id = id;
		this.hd = hd;
		this.ram = ram;
	}
    public String estado(){
        if(this.ligado){
            return "Ligado";
        }else{
            return "Desligado";
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
			return ""+this.cliente;
		}
	}

	public int getHD(){
		return this.hd;
	}

	public void aprontar(Cliente cliente){
		this.ligado = true;
		this.cliente = cliente;
		this.preparado = true;
	}

	public int procurarApp(String nome) throws AppNaoEncontradoException {
		int index = 0;
		while(index < apps.length){
			if(nome.equals(this.apps[index].getNome())){
				return index;
			}else{
				index += 1;
			}
		}
		throw new AppNaoEncontradoException();
	}

	public void executarAdministrador(String nome) throws AppNaoEncontradoException{
		apps[this.procurarApp(nome)].executarAdmnistrador();
	}

	public void executar(String nome) throws AppNaoEncontradoException {
		apps[this.procurarApp(nome)].executar();
	}

	public void instalar(Aplicativo app) throws SemEspacoNoDiscoExcpetion{
		boolean vazio = false;
		int indice = 0;

		if(hd_ocupado + app.getTamanho() > hd){
			throw new SemEspacoNoDiscoExcpetion();
		}else{
			while(vazio == false || indice<100){
				if(apps[indice] == null){
					vazio = true;
					continue;
				}else{
					indice += 1;
				}
			}
			if(vazio){
				/* COPIA TODOS PRA UM ARRAY DE APLICATIVOS COM MAIS 20 POSIÃ‡Ã•ES */
				Aplicativo [] appsUP = new Aplicativo [apps.length+20];

				for(int i=0;i<apps.length;i++){
					appsUP[i] = apps[i];
				}

				apps = appsUP;

			}else{
				apps[indice] = app;
				this.hd_ocupado += app.getTamanho();
			}
		}
	}


	/* observar estado atual da mÃ¡quina */
	public String estadoAtual(){
		return "Estado: " + this.estado() + '\n' +
				"Usuario: " + this.getUsuario() + '\n'+
				"HD Total: " + this.getHD() + '\n'+
				"HD Disponivel: " + (this.getHD() - this.hd_ocupado) + '\n'+
				"RAM Total: " + this.getRAM() + '\n'+
				"RAM Disponivel: " + (this.getRAM() - this.ram_ocupada);
	}

}
