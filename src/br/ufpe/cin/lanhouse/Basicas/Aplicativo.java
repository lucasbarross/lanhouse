package br.ufpe.cin.lanhouse.Basicas;

public class Aplicativo {
	
	private String nome;
	private int tamanho;
	boolean precisaAdm;
	int ramNecessaria;
	
	public Aplicativo(String nome, int tamanho, boolean precisaAdm, int ramNecessaria){
		this.nome = nome;
		this.tamanho = tamanho;
		this.precisaAdm = precisaAdm;
		this.ramNecessaria = ramNecessaria;
	}
	
	public String executar(){
		String resultado = "";
		
		if(!precisaAdm){
			resultado = nome+" foi executado com sucesso.";
		}else{
			resultado = nome+" precisa ser executado como administrador.";
		}
		return resultado;
	}
	
	public String executarAdmnistrador(){
		return nome+" foi executado com sucesso como administrador.";
	}
	
	public void renomear(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return this.nome;
	}

	public int getTamanho() {
		return tamanho;
	}
	
	public int getRamNecessaria(){
		return this.ramNecessaria;
	}
}
