package br.ufpe.cin.lanhouse.Basicas;

import br.ufpe.cin.lanhouse.Exceptions.*;

/**
 * Created by vlma on 16/06/2017.
 */
public class Impressora {
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

    public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getCargaTintaPreta() {
		return cargaTintaPreta;
	}

	public void setCargaTintaPreta(double cargaTintaPreta) {
		this.cargaTintaPreta = cargaTintaPreta;
	}

	public double getCargaTintaColorida() {
		return cargaTintaColorida;
	}

	public void setCargaTintaColorida(double cargaTintaColorida) {
		this.cargaTintaColorida = cargaTintaColorida;
	}

	public int getCargaPapel() {
		return cargaPapel;
	}

	public void setCargaPapel(int cargaPapel) {
		this.cargaPapel = cargaPapel;
	}

	public double getTintaPorPagina() {
		return tintaPorPagina;
	}

	public void setTintaPorPagina(double tintaPorPagina) {
		this.tintaPorPagina = tintaPorPagina;
	}

	public int getNumeroDeImpressoes() {
		return numeroDeImpressoes;
	}

	public void setNumeroDeImpressoes(int numeroDeImpressoes) {
		this.numeroDeImpressoes = numeroDeImpressoes;
	}

	public boolean isImpressaoCalibrada() {
		return impressaoCalibrada;
	}

	public void setImpressaoCalibrada(boolean impressaoCalibrada) {
		this.impressaoCalibrada = impressaoCalibrada;
	}

	public void recarregarTinta() {
        this.cargaTintaPreta = 1;
    }

    public void imprimirEmPreto(int numeroPaginas) throws OutOfPagesException, OutOfBlackInkException, ImpressoraDescalibradaException {
        if (impressaoCalibrada) {
            if (this.cargaPapel >= numeroPaginas) {
                if (cargaTintaPreta >= numeroPaginas * tintaPorPagina) {
                    this.cargaPapel = this.cargaPapel = numeroPaginas;
                    this.cargaTintaPreta = this.cargaTintaPreta - (numeroPaginas * tintaPorPagina);
                } else {
                    throw new OutOfBlackInkException();
                }
            } else {
                throw new OutOfPagesException();
            }
        } else {
            throw new ImpressoraDescalibradaException();
        }
    }
    
    public void imprimirEmColorido(int numeroPaginas) throws OutOfPagesException, OutOfCollorInkException, ImpressoraDescalibradaException {
        if (impressaoCalibrada) {
            if (this.cargaPapel >= numeroPaginas) {
                if (cargaTintaColorida >= numeroPaginas * tintaPorPagina) {
                    this.cargaPapel = this.cargaPapel = numeroPaginas;
                    this.cargaTintaColorida = this.cargaTintaColorida - (numeroPaginas * tintaPorPagina);
                } else {
                    throw new OutOfCollorInkException();
                }
            } else {
                throw new OutOfPagesException();
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
    }


}