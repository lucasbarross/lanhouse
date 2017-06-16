package br.ufpe.cin.lanhouse.Basicas;

public abstract class Pessoa {
	
	private String nome;
	private String cpf;
	private char sexo;
	private int idade;
	
	public Pessoa(String nome, String cpf, char sexo, int idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.idade = idade;
	}
	
	/* 
	 Funcionario quando usa aparece o tempo dos usuarios, cliente quando usa aparece a lista de aplicativos. 
	*/
	
	public abstract void usarComputador();
	
	/*
	 Cliente precisa de permissao para instalar, Funcionario nao.
	 */
	
	public abstract void instalarAplicativo(Aplicativo app, Computador computador);
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public char getSexo() {
		return sexo;
	}
	
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
}
