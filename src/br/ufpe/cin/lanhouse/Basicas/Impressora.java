package br.ufpe.cin.lanhouse.Basicas;

import br.ufpe.cin.lanhouse.Exceptions.*;

/**
 * Created by vlma on 16/06/2017.
 */
public class Impressora {
	//talvez retirar atributos marca e calibrado(????)
    private String marca;
    private String numero;
    private double cargaTintaPreta;
    private double cargaTintaColorida;
    private int cargaPapel;
    private final int CARGA_MAX_PAPEL;
    private double tintaPorPagina;
    private int numeroDeImpressoes;
    private boolean impressaoCalibrada;

    public Impressora(String m, String numero, int papelMax, double tPP) {
        this.marca = m;
        this.numero = numero;
        this.CARGA_MAX_PAPEL = papelMax;
        this.cargaPapel = 0;
        this.cargaTintaPreta = 0;
        this.cargaTintaColorida = 0;
        this.tintaPorPagina = tPP;
        this.impressaoCalibrada = false;
        this.numeroDeImpressoes = 0;
    }

	public String getNumero() {
		return numero;
	}

    public void imprimirEmPreto(int numeroPaginas) throws SemFolhaException, SemTintaPretaException, ImpressoraDescalibradaException {
        if (impressaoCalibrada) {
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
        } else {
            throw new ImpressoraDescalibradaException();
        }
    }
    
    public void imprimirEmColorido(int numeroPaginas) throws SemFolhaException, SemTintaColoridaException, ImpressoraDescalibradaException {
        if (impressaoCalibrada) {
            if (this.cargaPapel >= numeroPaginas) {
                if (cargaTintaColorida >= numeroPaginas * tintaPorPagina) {
                    this.cargaPapel = this.cargaPapel - numeroPaginas;
                    this.cargaTintaColorida = this.cargaTintaColorida - (numeroPaginas * this.tintaPorPagina);
                    this.numeroDeImpressoes++;
                } else {
                    throw new SemTintaColoridaException();
                }
            } else {
                throw new SemFolhaException();
            }
        } else {
            throw new ImpressoraDescalibradaException();
        }
    }
    

    public void recarregarPagina(int numeroDePaginas) throws NotEnoughRoomException {
        int total = this.cargaPapel + numeroDePaginas;
        if (total <= CARGA_MAX_PAPEL) {
            this.cargaPapel = total;
        } else {
            throw new NotEnoughRoomException();
        }
    }

    // talvez CalibradoException
    public void calibrar() {
        this.impressaoCalibrada = true;
        this.numeroDeImpressoes = 0;
    }


}