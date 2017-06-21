package br.ufpe.cin.lanhouse.basicas;

import br.ufpe.cin.lanhouse.exceptions.*;

/**
 * Created by vlma on 16/06/2017.
 */
public class Impressora {
    private final String marca;
    private final String numero;
    private double cargaTintaPreta;
    private double cargaTintaColorida;
    private int cargaPapel;
    private final int CARGA_MAX_PAPEL;
    private final double tintaPorPagina;
    private int numeroDeImpressoes;

    public Impressora(String marca, String numero, int papelMax, double tintaPorPagina) {
        this.marca = marca;
        this.numero = numero;
        this.CARGA_MAX_PAPEL = papelMax;
        this.cargaPapel = 0;
        this.cargaTintaPreta = 0;
        this.cargaTintaColorida = 0;
        this.tintaPorPagina = tintaPorPagina;
        this.numeroDeImpressoes = 0;
    }

	public String getId() {
		return numero;
	}

    public void imprimirEmPreto(int numeroPaginas) throws SemFolhaException, SemTintaPretaException {
        if (this.cargaPapel >= numeroPaginas) {
            if (cargaTintaPreta >= numeroPaginas * tintaPorPagina) {
                this.cargaPapel = this.cargaPapel - numeroPaginas;
                this.cargaTintaPreta = this.cargaTintaPreta - (numeroPaginas * this.tintaPorPagina);
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
            if (this.cargaTintaColorida >= numeroPaginas * this.tintaPorPagina) {
                this.cargaPapel = this.cargaPapel - numeroPaginas;
                this.cargaTintaColorida = this.cargaTintaColorida - (numeroPaginas * this.tintaPorPagina);
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
        if (total <= CARGA_MAX_PAPEL) {
            this.cargaPapel = total;
        } else {
            throw new SemEspacoPapelException();
        }
    }

    public void recarregarTintaPreta() {
        this.cargaTintaPreta = 1;
    }

    public void recarregarTintaColorida() {
        this.cargaTintaColorida = 1;
    }

    public String getMarca() {
        return this.marca;
    }


}