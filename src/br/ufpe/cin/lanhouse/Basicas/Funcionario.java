package br.ufpe.cin.lanhouse.Basicas;

import br.ufpe.cin.lanhouse.Exceptions.*;

public class Funcionario extends Pessoa{

	public Funcionario(String nome, String cpf, char sexo, int idade) {
		super(nome, cpf, sexo, idade);
	}
	
	public void ligarComputador(Computador computador) throws ComputadorLigadoException {
        computador.ligar();
    }

    public void desligarComputador(Computador computador) throws ComputadorDesligadoException {
        computador.desligar();
    }

    public void conectarCliente(Cliente cliente, Computador computador)
}
