package br.ufpe.cin.lanhouse.Fachada;
import br.ufpe.cin.lanhouse.Negocios.*;
public class Administrador {

    private CadastroAplicativos cadastroAplicativos;
    private CadastroComputadores cadastroComputadores;
    private CadastroImpressoras cadastroImpressoras;
    private CadastroPessoas cadastroPessoas;

    public void lerConfig(){
        boolean array = true; //leitura do arquivo config.txt;

        cadastroAplicativos= new CadastroAplicativos(array);
        cadastroComputadores = new CadastroComputadores();
        cadastroImpressoras = new CadastroImpressoras();
        cadastroPessoas = new CadastroPessoas();
    }


}
