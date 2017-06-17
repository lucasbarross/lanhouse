package br.ufpe.cin.lanhouse.Basicas;

public class Computador {

	private String id;
	private int hd;
	private int ram;
	private boolean ligado;
	private Cliente cliente;
	private Aplicativo apps [] = new Aplicativo [100];
	private int hd_ocupado = 0;
	private int ram_ocupada = 0;

	public Computador(String id, int hd, int ram){
		this.id = id;
		this.hd = hd;
		this.ram = ram;
	}

	public String getEstado(){
		if(ligado == true){
			return "Ligado";
		}else{
			return "Desligado";
		}
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

	public void aprontar(boolean ligado, Cliente cliente){
		this.ligado = true;
		this.cliente = cliente;
	}

	public boolean procurarApp(String nome){
		int index = 0;
		while(index < apps.length){
			if(nome == this.apps[index].getNome()){
				return true;
			}else{
				index+=1;
			}
		}
		/* EXCEPTION APP NÃO ENCONTRADO */
		return false;
	}

	public void executar(String nome){
		if(this.procurarApp(nome) == true){

		}
	}

	public void instalar(Aplicativo app){
		boolean vazio = false;
		int indice = 0;

		if(hd_ocupado + app.getTamanho() > hd){
			/* EXCEPTION SEM ESPAÇO NO DISCO */		
		} else{
			while(vazio == false && indice<100){
				if(apps[indice] == null){
					vazio = true;
					continue;
				}else{
					indice += 1;
				}
			}
			if(vazio == false){

				/* COPIA TODO MUNDO PRA UM ARRAY DE APLICATIVOS COM MAIS 20 POSIÇÕES */
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


	/* observar estado atual da máquina */
	public String estado(){
		return "Estado: " + this.estado() + '\n' +
				"Usuario: " + this.getUsuario() + '\n'+
				"HD Total: " + this.getHD() + '\n'+
				"HD Disponivel: " + (this.getHD() - this.hd_ocupado) + '\n'+
				"RAM Total: " + this.getRAM() + '\n'+
				"RAM Disponivel: " + (this.getRAM() - this.ram_ocupada);
	}

}
