package br.ufpe.cin.lanhouse.basicas;

import br.ufpe.cin.lanhouse.exceptions.*;
import br.ufpe.cin.lanhouse.repositorios.RepositorioListaClientes;

public class Funcionario extends Pessoa {
    private int clientesAtendidos;
    private final RepositorioListaClientes clientes;

	public Funcionario(String nome, String cpf, char sexo, int idade) {
		super(nome, cpf, sexo, idade);
        clientesAtendidos = 0;
        clientes = new RepositorioListaClientes();
	}

    public String usarComputador() {
        return this.clientes.getClientes();
    }

	public void ligarComputador(Computador computador) throws ComputadorLigadoException {
        computador.ligar();
    }

    public void desligarComputador(Computador computador) throws ComputadorDesligadoException {
        computador.desligar();
    }

    public void conectarCliente(Cliente cliente, Computador computador) throws ClienteComComputadorException, ComputadorUtilizadoException, ComputadorDesligadoException {
        computador.setCliente(cliente);
        cliente.setComputador(computador);
        clientesAtendidos++;
        clientes.inserir(cliente);
    }

    public void desconectarCliente(Computador computador) throws SemClienteException, PessoaNaoEncontradaException {
        String cpfCliente = computador.desconectarCliente();
        clientes.remover(cpfCliente);
    }

    public void passarTempo() {
        this.clientes.passarTempo();
    }
}