package br.ufpe.cin.lanhouse.basicas;

import br.ufpe.cin.lanhouse.exceptions.SemComputadorException;

public abstract class Pessoa {
	
	private String nome;
	private final String cpf;
	private char sexo;
	private int idade;

	Pessoa(String nome, String cpf, char sexo, int idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.idade = idade;
	}
	
	//usar computador em cliente retorna as informa��es do computador que o cliente est� usando, enquanto em funcion�rio retorna
	//as informa��es dos clientes associados ao funcion�rio.
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
