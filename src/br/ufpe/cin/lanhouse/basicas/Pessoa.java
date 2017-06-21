package br.ufpe.cin.lanhouse.basicas;

import br.ufpe.cin.lanhouse.exceptions.SemComputadorException;

public abstract class Pessoa {
	
	private final String nome;
	private final String cpf;
	private final char sexo;
	private final int idade;
	
	public Pessoa(String nome, String cpf, char sexo, int idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.idade = idade;
	}

	public abstract String usarComputador() throws SemComputadorException;

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	
	public char getSexo() {
		return sexo;
	}

	public int getIdade() {
		return idade;
	}
}
