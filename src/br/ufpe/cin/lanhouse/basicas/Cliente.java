package br.ufpe.cin.lanhouse.basicas;

import br.ufpe.cin.lanhouse.exceptions.*;

public class Cliente extends Pessoa{
    private Computador computador = null;
    private int tempoAtual;

	public Cliente(String nome, String cpf, char sexo, int idade) {
		super(nome, cpf, sexo, idade);
	}

    public void setComputador(Computador computador) throws ClienteComComputadorException {
        if(this.computador == null) {
            this.computador = computador;
        } else {
            throw new ClienteComComputadorException();
        }
    }

    public String getInfo() {
        return "Cliente: " + this.getNome() + ";\nCPF:" + this.getCpf() + ";" +
                "\nTempo Atual: " + this.tempoAtual + " minutos;\n";
    }

    public void passarTempo() {
        this.tempoAtual += 10;
    }

    public String usarComputador() throws SemComputadorException {
        if(computador != null) {
            return computador.estadoAtual();
        } else {
            throw new SemComputadorException();
        }
    }

	public String executarAplicativo(Aplicativo app) throws AppEmExecucaoException, SemRamException, SemComputadorException {
        if(this.computador == null) {
            throw new SemComputadorException();
        }
        return this.computador.executar(app);
	}

    public String encerrarAplicativo(Aplicativo app) throws AppNaoEncontradoException {
        return this.computador.encerrar(app);
    }

    public String desconectarComputador() {
        this.computador = null;
        this.tempoAtual = 0;
        return this.getCpf();
    }
}
