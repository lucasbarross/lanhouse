package br.ufpe.cin.lanhouse.basicas;

import br.ufpe.cin.lanhouse.exceptions.*;

public class Funcionario extends Pessoa {
    private int clientesAtendidos;

	public Funcionario(String nome, String cpf, char sexo, int idade) {
		super(nome, cpf, sexo, idade);
        clientesAtendidos = 0;
	}
	
	public void ligarComputador(Computador computador) throws ComputadorLigadoException {
        computador.ligar();
    }

    public void desligarComputador(Computador computador) throws ComputadorDesligadoException {
        computador.desligar();
    }

    public void conectarCliente(Cliente cliente, Computador computador) throws ClienteComComputadorException, ComputadorUtilizadoException {
        computador.setCliente(cliente);
        cliente.setComputador(computador);
        clientesAtendidos++;
    }

    public void desconectarCliente(Computador computador) throws SemClienteException {
        computador.desconectarCliente();
    }
}
