package br.ufpe.cin.lanhouse.exceptions;

/**
 * Created by sgfl on 21/06/2017.
 */
public class SemRamException extends Exception {
    public SemRamException(){
        super ("Memória Ram Insuficiente!");
    }
}
