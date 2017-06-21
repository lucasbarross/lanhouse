package br.ufpe.cin.lanhouse.Basicas;

import br.ufpe.cin.lanhouse.Exceptions.*;

public class Cliente extends Pessoa{
    Computador computador = null;

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

    public String getComputador() {
        return this.computador.getEstado();
    }

	public void executarAplicativo(Aplicativo app) throws AppEmExecucaoException, AppNaoEncontradoException, SemRamException {
        this.computador.executar(app);
	}

    public void desconectarComputador() {
        this.computador = null;
    }
}
