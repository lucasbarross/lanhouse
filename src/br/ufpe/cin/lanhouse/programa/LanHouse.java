package br.ufpe.cin.lanhouse.programa;

import br.ufpe.cin.lanhouse.basicas.Aplicativo;
import br.ufpe.cin.lanhouse.interfaces.RepositorioAplicativos;
import br.ufpe.cin.lanhouse.repositorios.RepositorioListaAplicativos;

public class LanHouse {

	public static void main(String[] args) {
		RepositorioListaAplicativos apps = new RepositorioListaAplicativos();
		apps.inserir(new Aplicativo("Skype", 10, 100));
		apps.inserir(new Aplicativo("Skype2", 10, 100));
		apps.inserir(new Aplicativo("Skype3", 10, 100));
		apps.inserir(new Aplicativo("Skype4", 10, 100));
		System.out.println(apps.getApps());
	}

}
