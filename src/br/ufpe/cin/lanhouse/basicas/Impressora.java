package br.ufpe.cin.lanhouse.basicas;

import br.ufpe.cin.lanhouse.exceptions.*;

public class Impressora {
    private String marca;
    private final String id;
    private double cargaTintaPreta;
    private double cargaTintaColorida;
    private int cargaPapel;
    private int cargaMaxPapel;
    private double tintaPorPagina;

    public Impressora(String marca, String id, int papelMax, double tintaPorPagina) {
        this.marca = marca;
        this.id = id;
        this.cargaMaxPapel = papelMax;
        this.cargaPapel = 0;
        this.cargaTintaPreta = 0.0;
        this.cargaTintaColorida = 0.0;
        this.tintaPorPagina = tintaPorPagina;
    }

	public String getId() {
		return this.id;
	}

    public void imprimirEmPreto(int numeroPaginas) throws SemFolhaException, SemTintaPretaException {
        if (this.cargaPapel >= numeroPaginas) {
            if (this.cargaTintaPreta >= this.tintaPorPagina * numeroPaginas) {
                this.cargaPapel -= numeroPaginas;
                this.cargaTintaPreta -= (this.tintaPorPagina * numeroPaginas);
            } else {
                throw new SemTintaPretaException(this.id);
            }
        } else {
            throw new SemFolhaException(this.id);
        }
    }
    
    public void imprimirEmColorido(int numeroPaginas) throws SemFolhaException, SemTintaColoridaException {
        if (this.cargaPapel >= numeroPaginas) {
            if (this.cargaTintaColorida >= this.tintaPorPagina * numeroPaginas) {
                this.cargaPapel -= numeroPaginas;
                this.cargaTintaColorida -= (this.tintaPorPagina* numeroPaginas);
            } else {
                throw new SemTintaColoridaException(this.id);
            }
        } else {
            throw new SemFolhaException(this.id);
        }
    }

    public void recarregarPagina(int numeroDePaginas) throws SemEspacoPapelException {
        int total = this.cargaPapel + numeroDePaginas;
        if (total <= this.cargaMaxPapel) {
            this.cargaPapel = total;
        } else {
            throw new SemEspacoPapelException(this.id);
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

    public String getEstado() {
        return this.marca + ' ' + this.id +
                ":\n - Numero de Páginas: " + this.cargaPapel + '/' +  this.cargaMaxPapel +
                ";\n - Tinta por Página: " + this.tintaPorPagina +
                ";\n - Carga de Tinta Preta: " + this.cargaTintaPreta + "/1.0" +
                ";\n - Carga de Tinta Colorida: " + this.cargaTintaColorida + "/1.0;\n";
    }
    public boolean comparar(String id) {
        return this.id.equals(id);
    }
}