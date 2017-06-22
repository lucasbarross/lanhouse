package br.ufpe.cin.lanhouse.basicas;

import br.ufpe.cin.lanhouse.exceptions.SemComputadorException;

public abstract class Pessoa {
	
	private String nome;
	private final String cpf;
	private char sexo;
	private int idade;
	
	public Pessoa(String nome, String cpf, char sexo, int idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.idade = idade;
	}

	public abstract String usarComputador() throws SemComputadorException;

	public String getNome() {
		return this.nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	
	public char getSexo() {
		return this.sexo;
	}

	public int getIdade() {
		return this.idade;
	}

    public boolean comparar(String cpf) {
        return this.cpf.equals(cpf);
    }

}
