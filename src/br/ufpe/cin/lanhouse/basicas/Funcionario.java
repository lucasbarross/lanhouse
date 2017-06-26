package br.ufpe.cin.lanhouse.basicas;

import br.ufpe.cin.lanhouse.exceptions.*;
import br.ufpe.cin.lanhouse.repositorios.RepositorioListaClientes;

public class Funcionario extends Pessoa {
    private RepositorioListaClientes clientes;

	public Funcionario(String nome, String cpf, char sexo, int idade) {
		super(nome, cpf, sexo, idade);
        this.clientes = new RepositorioListaClientes();
	}
	
	//Retorna as informa��es dos clientes que est�o associados ao funcionario.
    public String usarComputador() {
        return this.clientes.getClientes();
    }
    
    //Conecta um dado cliente a um dado computador.
    public void conectarCliente(Cliente cliente, Computador computador) throws ClienteComComputadorException, ComputadorUtilizadoException, ComputadorDesligadoException {
        computador.setCliente(cliente);
        cliente.setComputador(computador);
        this.clientes.inserir(cliente);
    }
    
    //Desconecta um cliente de um computador.
    public void desconectarCliente(Computador computador) throws SemClienteException, PessoaNaoEncontradaException {
        String cpfCliente = computador.desconectarCliente();
        this.clientes.remover(cpfCliente);
    }
    
    //Passa o tempo para todos os clientes que est�o associados a esse funcion�rio.
    public void passarTempo() {
        this.clientes.passarTempo();
    }
}