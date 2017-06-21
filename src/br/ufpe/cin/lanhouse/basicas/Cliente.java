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

    public int getTempoAtual() {
        return this.tempoAtual;
    }

    public String getInfo() {
        String info = "Cliente: " + this.getNome() + ";\nCPF:" + this.getCpf() + ";" +
                "\nTempo Atual: " + this.getTempoAtual() + " minutos;\n";
        return info;
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

	public void executarAplicativo(Aplicativo app) throws AppEmExecucaoException, AppNaoEncontradoException, SemRamException {
        this.computador.executar(app);
	}

    public void desconectarComputador() {
        this.computador = null;
        this.tempoAtual = 0;
    }
}
