package br.ufpe.cin.lanhouse.Basicas;

public class Aplicativo {
	
	private String nome;
	private int tamanho;
	private boolean executado;
	private int ramNecessaria;
	
	public Aplicativo(String nome, int tamanho, boolean precisaAdm, int ramNecessaria){
		this.nome = nome;
		this.tamanho = tamanho;
		this.executado = false;
		this.ramNecessaria = ramNecessaria;
	}
	
	public String executar(){
		executado = true;
		return nome+" foi executado com sucesso.";
	}
	public void encerrar(){
		executado = false;
	}
	
	public void renomear(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return this.nome;
	}
	public boolean getExecutado(){
		return executado;
	}

	public int getTamanho() {
		return tamanho;
	}
	
	public int getRamNecessaria(){
		return this.ramNecessaria;
	}
}
