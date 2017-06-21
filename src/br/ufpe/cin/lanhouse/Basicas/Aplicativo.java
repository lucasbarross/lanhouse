package br.ufpe.cin.lanhouse.Basicas;

public class Aplicativo {
	
	private String nome;
	private int tamanho;
	private int ramNecessaria;
	
	public Aplicativo(String nome, int tamanho, int ramNecessaria){
		this.nome = nome;
		this.tamanho = tamanho;
		this.ramNecessaria = ramNecessaria;
	}
	
	public String executar(){
		return nome + " foi executado com sucesso.";
	}

	public String encerrar(){
		return nome + " foi encerrado com sucesso.";
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
