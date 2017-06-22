package br.ufpe.cin.lanhouse.basicas;

import br.ufpe.cin.lanhouse.exceptions.*;

public class Cliente extends Pessoa{
    private Computador computador = null;
    private int tempoAtual = 0;

	public Cliente(String nome, String cpf, char sexo, int idade) {
		super(nome, cpf, sexo, idade);
	}

    public void setComputador(Computador computador) throws ClienteComComputadorException {
        if(this.computador == null) {
            this.computador = computador;
        } else {
            throw new ClienteComComputadorException(this.getNome(), this.getCpf());
        }
    }

    public String getInfo() {
        return "Cliente: " + this.getNome() + ";\nCPF:" + this.getCpf() + ';' +
                "\nTempo Atual: " + this.tempoAtual + " minutos;\n";
    }

    public void passarTempo() {
        this.tempoAtual += 10;
    }

    public String usarComputador() throws SemComputadorException {
        if(this.computador != null) {
            return this.computador.estadoAtual();
        } else {
            throw new SemComputadorException(this.getNome(), this.getCpf());
        }
    }

	public String executarAplicativo(Aplicativo app) throws AplicativoEmExecucaoException, SemRamException, SemComputadorException {
        if(this.computador == null) {
            throw new SemComputadorException(this.getNome(), this.getCpf());
        }
        return this.computador.executar(app);
	}

    public String encerrarAplicativo(Aplicativo app) throws AplicativoNaoEncontradoException {
        return this.computador.encerrar(app);
    }

    public String desconectarComputador() {
        this.computador = null;
        this.tempoAtual = 0;
        return this.getCpf();
    }
}
