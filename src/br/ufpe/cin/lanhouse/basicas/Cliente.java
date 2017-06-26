package br.ufpe.cin.lanhouse.basicas;

import br.ufpe.cin.lanhouse.exceptions.*;

public class Cliente extends Pessoa{
	//computador que o cliente está usando
    private Computador computador = null;
    //tempo em que o cliente está na lan house
    private int tempoAtual = 0;

	public Cliente(String nome, String cpf, char sexo, int idade) {
		super(nome, cpf, sexo, idade);
	}
	
	//Seta a variavel computador a um computador passado como argumento, fazendo a ligação cliente-computador.
    public void setComputador(Computador computador) throws ClienteComComputadorException {
        if(this.computador == null) {
            this.computador = computador;
        } else {
            throw new ClienteComComputadorException(this.getNome(), this.getCpf());
        }
    }

    //retorna as informações do cliente.
    public String getInfo() {
        return "Cliente: " + this.getNome() + ";\nCPF: " + this.getCpf() + ';' +
                "\nTempo Atual: " + this.tempoAtual + " minutos;\n";
    }
    
    //passa o tempo em que o cliente está na lan house.
    public void passarTempo() {
        this.tempoAtual += 10;
    }
    
    //retorna as informações do computador em que o cliente está
    public String usarComputador() throws SemComputadorException {
        if(this.computador != null) {
            return this.computador.estadoAtual();
        } else {
            throw new SemComputadorException(this.getNome(), this.getCpf());
        }
    }
    
    //executa um aplicativo no computador do cliente.
	public String executarAplicativo(Aplicativo app) throws AplicativoEmExecucaoException, SemRamException, SemComputadorException {
        if(this.computador == null) {
            throw new SemComputadorException(this.getNome(), this.getCpf());
        }
        return this.computador.executar(app);
	}
	
	//encerra o aplicativo no computador do cliente.
    public String encerrarAplicativo(Aplicativo app) throws AplicativoNaoEncontradoException {
        return this.computador.encerrar(app);
    }

    public String desconectarComputador() {
        this.computador = null;
        this.tempoAtual = 0;
        return this.getCpf();
    }
}
