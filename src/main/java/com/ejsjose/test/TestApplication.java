package com.ejsjose.test;

import com.ejsjose.utils.Aplicativo;

public class TestApplication extends Aplicativo {

    public static void main(String[] args) {
        TestApplication app = new TestApplication();
        
        // Adicionar menus de teste
        app.addOpcao(-1, TP_OPCAO_MENU, "Teste", "", 'T', 200000000, 0, false, null);
        app.addOpcao(200000000, TP_OPCAO_ITEM, "Item Teste 1", "Item Teste 1", '1', 200000001, 1, true, null);
        app.addOpcao(200000000, TP_OPCAO_ITEM, "Item Teste 2", "Item Teste 2", '2', 200000002, 1, true, null);
        
        // Ajustar menus novamente para garantir que estão atualizados
        app.ajustaMenu();
        
        // Mostrar aplicação
        app.show();
        
        System.out.println("Aplicação de teste iniciada com menus");
    }
}
