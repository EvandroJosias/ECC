package com.ejsjose;

import com.ejsjose.views.mainScreen;

public class EccApplication {

	public static void main(String[] args) {

		EccApplication app = new EccApplication();
       
        mainScreen screen = null;
        try {
            screen = new mainScreen();
            screen.displayMenu();
        } catch (Exception e) {
            System.err.println("Erro na aplicação: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (screen != null) {
                screen.dispose(); // Libera recursos da tela
            }
        }

	}

}


 