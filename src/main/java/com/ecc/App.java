package com.ecc;

import com.ecc.view.MainWindows;

public class App {
    public static void main( String[] args )  {

        MainWindows janela = new MainWindows("ECC - Encontro de Casais com Cristo");
        janela.setVisible(true);
        System.out.println( "Hello World!" );
    }
}
