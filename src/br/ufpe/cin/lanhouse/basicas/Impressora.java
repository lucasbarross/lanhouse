package br.ufpe.cin.lanhouse.basicas;

import br.ufpe.cin.lanhouse.exceptions.*;

/**
 * Created by vlma on 16/06/2017.
 */
public class Impressora {
    private String marca;
    private final String id;
    private double cargaTintaPreta;
    private double cargaTintaColorida;
    private int cargaPapel;
    private int cargaMaxPapel;
    private double tintaPorPagina;
    private int numeroDeImpressoes;

    public Impressora(String marca, String numero, int papelMax, double tintaPorPagina) {
        this.marca = marca;
        this.id = numero;
        this.cargaMaxPapel = papelMax;
        this.cargaPapel = 0;
        this.cargaTintaPreta = 0.0;
        this.cargaTintaColorida = 0.0;
        this.tintaPorPagina = tintaPorPagina;
        this.numeroDeImpressoes = 0;
    }

	public String getId() {
		return this.id;
	}

    public void imprimirEmPreto(int numeroPaginas) throws SemFolhaException, SemTintaPretaException {
        if (this.cargaPapel >= numeroPaginas) {
            if (this.cargaTintaPreta >= this.tintaPorPagina * numeroPaginas) {
                this.cargaPapel -= numeroPaginas;
                this.cargaTintaPreta -= (this.tintaPorPagina * numeroPaginas);
                this.numeroDeImpressoes++;
            } else {
                throw new SemTintaPretaException();
            }
        } else {
            throw new SemFolhaException();
        }
    }
    
    public void imprimirEmColorido(int numeroPaginas) throws SemFolhaException, SemTintaColoridaException {
        if (this.cargaPapel >= numeroPaginas) {
            if (this.cargaTintaColorida >= this.tintaPorPagina * numeroPaginas) {
                this.cargaPapel -= numeroPaginas;
                this.cargaTintaColorida -= (this.tintaPorPagina* numeroPaginas);
                this.numeroDeImpressoes += numeroPaginas;
            } else {
                throw new SemTintaColoridaException();
            }
        } else {
            throw new SemFolhaException();
        }
    }

    public void recarregarPagina(int numeroDePaginas) throws SemEspacoPapelException {
        int total = this.cargaPapel + numeroDePaginas;
        if (total <= this.cargaMaxPapel) {
            this.cargaPapel = total;
        } else {
            throw new SemEspacoPapelException();
        }
    }

    public void recarregarTintaPreta() {
        this.cargaTintaPreta = 1.0;
    }

    public void recarregarTintaColorida() {
        this.cargaTintaColorida = 1.0;
    }

    public String getMarca() {
        return this.marca;
    }

    public boolean comparar(String id) {
        return this.id.equals(id);
    }
}