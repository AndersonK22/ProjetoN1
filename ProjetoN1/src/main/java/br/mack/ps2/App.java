package br.mack.ps2;

import br.mack.ps2.persistencia.PaisDAOMySQL;

public class App {
    public static void main(final String[] args) {
        PaisDAOMySQL mysqlDAO = new PaisDAOMySQL();
        Interface anInterface = new Interface(mysqlDAO);
        anInterface.iniciar();
    }
}